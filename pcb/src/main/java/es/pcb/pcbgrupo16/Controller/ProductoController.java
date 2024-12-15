package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

    @Autowired
    private AtributoRepository atributoRepository;

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private RelacionRepository relacionRepository;

    @GetMapping("/")
    public String listarProductos(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Producto> listaProductos = productoRepository.findAllByCuenta(cuenta.getId());

        model.addAttribute("productos", listaProductos);

        return "Products/listProducts";
    }

    @GetMapping("/delete")
    public String eliminarProducto(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        productoCategoriaRepository.deleteByIdProducto(id);
        contenidoRepository.deleteByProducto(id);
        relacionRepository.setProd1AndProd2NullById(id);
        productoRepository.deleteById(id);

        Cuenta cuenta = usuario.getCuenta();
        List<Producto> listaProductos = productoRepository.findAllByCuenta(cuenta.getId());
        model.addAttribute("productos", listaProductos);
        return "Products/listProducts";
    }

    @GetMapping("/create")
    public String crearProducto(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        Cuenta cuenta = usuario.getCuenta();

        List<Categoria> categorias = categoriaRepository.findAll();
        List<Atributo> atributos = new ArrayList<>();
        atributos = atributoRepository.findAllByCuenta(cuenta);

        model.addAttribute("categorias", categorias);
        model.addAttribute("atributos", atributos);
        return "Products/createProducts";
    }

    @PostMapping("/create")
    public String crearProducto(
            @ModelAttribute Producto producto,
            Model model,
            HttpSession session,
            @RequestParam("thumbnail") String thumbnail,
            @RequestParam("category") Integer idCategoria,
            @RequestParam Map<String, String> allParams) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        // Obtenemos la cuenta asociada al usuario
        Cuenta cuenta = usuario.getCuenta();
        producto.setCuenta(cuenta);
        producto.setFechaCreacion(LocalDate.now());
        producto.setFechaModificacion(LocalDate.now());
        producto.setThumnail(thumbnail);

        // Guardamos el producto
        productoRepository.save(producto);

        // Manejo de atributos dinámicos y creación de Contenidos
        allParams.forEach((key, value) -> {
            if (key.startsWith("atributo-")) {
                try {
                    // Extraemos el ID del atributo
                    Integer atributoId = Integer.parseInt(key.substring("atributo-".length()));

                    // Obtenemos el atributo por ID
                    Atributo atributo = atributoRepository.findById(atributoId).orElse(null);

                    if (atributo != null) {
                        // Crear el contenido asociado al producto y atributo
                        Contenido contenido = new Contenido();
                        contenido.setProducto(producto); // Asociar al producto
                        contenido.setAtributo(atributo); // Asociar al atributo
                        contenido.setContenido(value);   // Guardar el valor del input
                        contenidoRepository.save(contenido); // Guardar el contenido en la BD
                    }
                } catch (NumberFormatException e) {
                    // Manejo de errores si el ID no es válido
                    System.err.println("Invalid atributo ID: " + key);
                }
            }
        });

        // Obtenemos la categoría seleccionada
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if (categoria == null) {
            model.addAttribute("error", "Categoría no encontrada.");
            return "Products/errorProducto"; // Mostrar error si no se encuentra la categoría
        }

        // Crear relación entre Producto y Categoría
        ProductocategoriaId productocategoriaId = new ProductocategoriaId();
        productocategoriaId.setIdProducto(producto.getId());
        productocategoriaId.setIdCategoria(idCategoria);

        Productocategoria productocategoria = new Productocategoria();
        productocategoria.setId(productocategoriaId);
        productocategoria.setIdProducto(producto);
        productocategoria.setIdCategoria(categoria);

        productoCategoriaRepository.save(productocategoria); // Guardar la relación

        model.addAttribute("productos", productoRepository.findAll());
        return "Products/listProducts";
    }



    @GetMapping("/edit")
    public String editarProducto(Model model, HttpSession session, @RequestParam("id") Integer id){

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();

        List<Contenido> contenidos = contenidoRepository.getContenidoByProducto(id);

        List<Atributo> atributos = atributoRepository.findAllByCuenta(cuenta);
        List<Object[]> tuplaAC = new ArrayList<>();

        for(Atributo atributo : atributos){
            Contenido contenido = contenidoRepository.findByAtributoAndId(atributo.getId(), id);
            tuplaAC.add(new Object[] { atributo, contenido });
        }
        
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        model.addAttribute("categoriasProducto", categoriaRepository.findAll());
        model.addAttribute("tuplaAC",tuplaAC);

        
        
        return "Products/editProducts";
    }
    @PostMapping("/edit")
    public String editarProducto(
            @RequestParam("id") Integer id,
            @RequestParam("gtin") Integer gtin,
            @RequestParam("nombre") String nombre,
            @RequestParam("thumbnail") String thumbnail,
            @RequestParam("category") Integer categoryId,
            @RequestParam Map<String, String> allParams,
            Model model,
            HttpSession session){

        // Filtrar únicamente las claves que correspondan a los IDs de atributos (dinámicos)
        Map<String, String> atributos = allParams.entrySet()
                .stream()
                .filter(entry -> entry.getKey().matches("\\d+")) // Filtrar solo claves numéricas (IDs de atributos)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Producto prod_mod = productoRepository.findById(id).get();

        //prod_mod.setFechaModificacion(producto.getFechaModificacion());
        prod_mod.setNombre(nombre);
        prod_mod.setGtin(gtin);
        prod_mod.setFechaModificacion(LocalDate.now());
        prod_mod.setThumnail(thumbnail);

        Categoria categoria = categoriaRepository.findById(categoryId).orElse(null);
        if (categoria == null) {
            model.addAttribute("error", "Categoría no encontrada.");
            return "Products/errorProducto"; // Si la categoría no existe, mostramos un error
        }

        for (Map.Entry<String, String> entry : atributos.entrySet()) {


            Integer atributoId = Integer.parseInt(entry.getKey());
            String valor = entry.getValue();

            Atributo atributo = atributoRepository.findById(atributoId).orElse(null);
            Contenido contenido = contenidoRepository.findByAtributoAndId(atributoId, id);
            if(contenido == null){
                contenido = new Contenido();
                contenido.setProducto(prod_mod);
                contenido.setAtributo(atributo);
            }
            contenido.setContenido(valor);
            contenidoRepository.save(contenido);
        }
        //MARCOS PUTERO (si soy)


        // Creamos el ID embebido para la relación de Producto y Categoría
        ProductocategoriaId productocategoriaId = new ProductocategoriaId();
        productocategoriaId.setIdProducto(id);
        productocategoriaId.setIdCategoria(categoryId);

        // Creamos el objeto Productocategoria
        Productocategoria productocategoria = new Productocategoria();
        productocategoria.setId(productocategoriaId); // Establecemos el ID embebido
        productocategoria.setIdProducto(prod_mod); // Establecemos la relación con Producto
        productocategoria.setIdCategoria(categoria); // Establecemos la relación con Categoria

        productoCategoriaRepository.deleteByIdProducto(prod_mod.getId());

        // Guardamos la relación en la tabla productocategoria
        productoCategoriaRepository.save(productocategoria);

        productoRepository.save(prod_mod);
        model.addAttribute("productos",productoRepository.findAll());
        return "Products/listProducts";
    }


    @GetMapping("/view")
    public String getProducto(Model model, HttpSession session, @RequestParam("id") Integer id) {
        // Verificar que el usuario está en sesión
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        // Buscar el producto por ID
        Producto producto = productoRepository.findById(id).orElse(null);

        // Verificar si el producto existe
        if (producto == null) {
            model.addAttribute("error", "El producto no existe.");
            return "Products/errorProducto";
        }

        List<Productocategoria> productocategorias = productoCategoriaRepository.findByIdIdProducto(id);
        List<Categoria> categorias = new ArrayList<>();
        if(productocategorias != null && !productocategorias.isEmpty()){
            ProductocategoriaId categoria1 = productocategorias.getFirst().getId();
            Categoria categoria11 = categoriaRepository.getById(categoria1.getIdCategoria());
            categorias.add(categoria11);
        }

        List<Contenido> contenidos = new ArrayList<>();
        contenidos = contenidoRepository.getContenidoByProducto(id);

        model.addAttribute("contenidos", contenidos);
        model.addAttribute("categoriasProducto", categorias);
        model.addAttribute("producto", producto);

        // Retornar la vista con las especificaciones
        return "Products/viewProducts";
    }

}