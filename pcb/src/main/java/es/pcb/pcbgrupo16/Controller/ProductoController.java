package es.pcb.pcbgrupo16.Controller;


import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Producto;
import es.pcb.pcbgrupo16.Entities.Usuario;
import es.pcb.pcbgrupo16.Repository.CategoriaRepository;
import es.pcb.pcbgrupo16.Repository.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;


    @GetMapping("/products")
    public String listarProductos(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Producto> listaProductos = productoRepository.findAllByCuenta(cuenta.getId());

        model.addAttribute("productos", listaProductos);

        return "Products/listadoProductos";
    }

    @GetMapping("/products/delete/{id}")
    public String eliminarProducto(Model model, HttpSession session, @PathVariable Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/Home/login";
        }
        productoRepository.deleteById(id);
        Cuenta cuenta = usuario.getCuenta();
        List<Producto> listaProductos = productoRepository.findAllByCuenta(cuenta.getId());
        model.addAttribute("productos", listaProductos);
        return "Products/listadoProductos";
    }

    @GetMapping("/create")
    public String crearProducto(@ModelAttribute Producto producto, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/Home/login";
        }
        Cuenta cuenta = (Cuenta) usuario.getCuenta();

        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);

        producto.setCuenta(cuenta);
        producto.setFechaCreacion(LocalDate.now());
        producto.setFechaModificacion(LocalDate.now());
        productoRepository.save(producto);
        return "Products/crearProducto";
    }

    @GetMapping("/edit")
    public String editarProducto(@ModelAttribute Producto producto/*Producto que he de modificar*/, Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Producto prod_mod = productoRepository.findById(producto.getId()).get();

        prod_mod.setFechaModificacion(producto.getFechaModificacion());
        prod_mod.setNombre(producto.getNombre());
        prod_mod.setFechaModificacion(producto.getFechaModificacion());
        prod_mod.setCuenta(producto.getCuenta());
        producto.setThumnail(producto.getThumnail());

        return"Products/listadoProductos";
    }


    @GetMapping("/get")
    public String getProducto(@RequestParam Integer id, Model model, HttpSession session) {
        // Verificar que el usuario está en sesión
        Usuario usuario = (Usuario) session.getAttribute("usuario");
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

        // Pasar los datos del producto al modelo
        model.addAttribute("producto", producto);

        // Retornar la vista con las especificaciones
        return "Products/especificacionesProducto";
    }

}