package es.pcb.pcbgrupo16.Controller;


import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Producto;
import es.pcb.pcbgrupo16.Entities.Usuario;
import es.pcb.pcbgrupo16.Repository.ProductoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductoController extends BaseController {

    @Autowired
    private ProductoRepository productoRepository;


    @GetMapping("/")
    public String listarProductos(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Cuenta cuenta = (Cuenta) usuario.getCuenta();
        List<Producto> listaProductos = productoRepository.findAllByCuenta(cuenta.getId());

        model.addAttribute("productos", listaProductos);

        return "Productos/listadoProductos";
    }

    @GetMapping("/delete")
    public String eliminarProducto(Model model, HttpSession session, @RequestParam Integer id) {

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        productoRepository.deleteById(id);
        return "redirect:/products/";
    }


//    @Autowired
//    private ProductoService productoService;
//
//
//    @GetMapping
//    public List<AtributoUsuario> listarProductos(){
//        return atributoService.allAtributos();
//    }
//
//    @GetMapping("/{id}")
//    public AtributoUsuario getAtributo(@PathVariable float id){
//        return atributoService.getAtributo(id);
//        //TODO controloar fallos
//    }
//
//    @PostMapping("/crearatr")
//    public AtributoUsuario crearAtributo(@RequestBody AtributoUsuario atr){
//        return atributoService.createAtribute(atr);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAtributo(@PathVariable float id){
//        return atributoService.deleteAtributo(id);
//        // TODO controlar errores
//
//    }
//
//    @PutMapping("/{id}")
//    public AtributoUsuario updateAtributo(@PathVariable float id, @RequestBody AtributoUsuario cosasnuevas ){
//        AtributoUsuario atributo = atributoService.getAtributo(id);
//
//        atributo.setNombre(cosasnuevas.getNombre());
//        atributo.setTipo(cosasnuevas.getTipo());
//        return atributoService.createAtribute(atributo);
//    }
}
