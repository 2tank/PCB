package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.CategoriaRepository;
import es.pcb.pcbgrupo16.Repository.ProductoCategoriaRepository;
import es.pcb.pcbgrupo16.Repository.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

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
        model.addAttribute("categorias", categorias);
        return "Products/createProducts";
    }

    @PostMapping("/create")
    public String crearProducto(@ModelAttribute Producto producto, Model model, HttpSession session, @RequestParam("category") Integer idCategoria) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        Cuenta cuenta = usuario.getCuenta();
        System.out.println(producto.getNombre());
        producto.setCuenta(cuenta);
        producto.setFechaCreacion(LocalDate.now());
        producto.setFechaModificacion(LocalDate.now());
        productoRepository.save(producto); // Guardamos el producto

        // Obtenemos la categoría
        Categoria categoria = categoriaRepository.findById(idCategoria).orElse(null);
        if (categoria == null) {
            model.addAttribute("error", "Categoría no encontrada.");
            return "Products/errorProducto"; // Si la categoría no existe, mostramos un error
        }

        // Creamos el ID embebido para la relación de Producto y Categoría
        ProductocategoriaId productocategoriaId = new ProductocategoriaId();
        productocategoriaId.setIdProducto(producto.getId());
        productocategoriaId.setIdCategoria(idCategoria);

        // Creamos el objeto Productocategoria
        Productocategoria productocategoria = new Productocategoria();
        productocategoria.setId(productocategoriaId); // Establecemos el ID embebido
        productocategoria.setIdProducto(producto); // Establecemos la relación con Producto
        productocategoria.setIdCategoria(categoria); // Establecemos la relación con Categoria

        // Guardamos la relación en la tabla productocategoria
        productoCategoriaRepository.save(productocategoria);

        model.addAttribute("productos", productoRepository.findAll());
        return "Products/listProducts";
    }


    @GetMapping("/edit")
    public String editarProducto(Model model, HttpSession session, @RequestParam("id") Integer id){

        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("producto", productoRepository.findById(id).orElse(null));
        model.addAttribute("categoriasProducto", categoriaRepository.findAll());

        return "Products/editProducts";
    }
    @PostMapping("/edit")
    public String editarProducto(@ModelAttribute Producto producto/*Producto que he de modificar*/, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Producto prod_mod = productoRepository.findById(producto.getId()).get();

        prod_mod.setFechaModificacion(producto.getFechaModificacion());
        prod_mod.setNombre(producto.getNombre());
        prod_mod.setFechaModificacion(producto.getFechaModificacion());
        producto.setThumnail(producto.getThumnail());

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

        ProductocategoriaId categoria1 = productocategorias.getFirst().getId();
        Categoria categoria11 = categoriaRepository.getById(categoria1.getIdCategoria());

        System.out.println(categoria11.getNombre());

        // Pasar los datos del producto al modelo
        model.addAttribute("producto", producto);
        model.addAttribute("categoriasProducto", categoria11);

        // Retornar la vista con las especificaciones
        return "Products/viewProducts";
    }

}