package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.ProductoRepository;
import es.pcb.pcbgrupo16.Repository.RelacionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/relationships")
public class RelacionController extends BaseController{


    @Autowired
    private RelacionRepository relacionRepository;
    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping("/")
    public String listarRelaciones(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Relacion> listaRelaciones = relacionRepository.findAllByCuenta(cuenta);

        model.addAttribute("relaciones", listaRelaciones);

        return "Relationship/listRelationship";
    }

    @GetMapping("/delete")
    public String eliminarRelacion(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        Relacion relacion_borrar = (Relacion) relacionRepository.findRelacionById(id);
        relacionRepository.delete(relacion_borrar);
        Cuenta cuenta = usuario.getCuenta();
        List<Relacion> listaRelaciones = relacionRepository.findAllByCuenta(cuenta);
        model.addAttribute("relaciones", listaRelaciones);
        return "Relationship/listRelationship";
    }

    @GetMapping("/create")
    public String crearRelacion(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        List<Relacion> relaciones = relacionRepository.findAllByCuenta(usuario.getCuenta());
        if(relaciones != null && relaciones.size() >= 3){
            return "redirect:/relationships/";
        }
        Cuenta cuenta = usuario.getCuenta();

        List<Producto> productos = productoRepository.findAll();

        model.addAttribute("productos", productos);

        return "Relationship/createRelationship";
    }

    @PostMapping("/create")
    public String crearRelacion(Model model, HttpSession session,
                                @RequestParam("nombre") String nombre,
                                @RequestParam("producto1") Integer id1,
                                @RequestParam("producto2") Integer id2){

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Producto p1; Producto p2;
        if(id1 == -1) p1 = null; else p1 = productoRepository.findProductoById(id1);
        if(id2 == -1) p2 = null; else p2 = productoRepository.findProductoById(id2);
        if((p1 == null && p2 != null) || (p1 != null && p2 == null)){
            return "redirect:/relationships/create";
        }
        Relacion relacion = new Relacion();
        relacion.setCuenta(usuario.getCuenta());
        relacion.setName(nombre);
        relacion.setProd1(p1);
        relacion.setProd2(p2);

        relacionRepository.save(relacion);

        model.addAttribute("relaciones", relacionRepository.findAllByCuenta(usuario.getCuenta()));

        return "Relationship/listRelationship";
    }

    @GetMapping("/edit")
    public String editarRelacion(Model model, HttpSession session, @RequestParam("id") Integer id){
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        model.addAttribute("productos", productoRepository.findAllByCuenta(usuario.getCuenta().getId()));
        model.addAttribute("relacion",relacionRepository.findRelacionById(id));
        return "Relationship/editRelationship";
    }


    @PostMapping("/edit")
    public String editarRelacion(Model model, HttpSession session,
                                 @RequestParam("id") Integer id, @RequestParam("nombre") String nombre,
                                 @RequestParam("producto1")Integer id1, @RequestParam("producto2") Integer id2){
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");

        Relacion rel_mod = relacionRepository.findRelacionById(id);

        Producto p1; Producto p2;
        if(id1 == -1) p1 = null; else p1 = productoRepository.findProductoById(id1);
        if(id2 == -1) p2 = null; else p2 = productoRepository.findProductoById(id2);
        if((p1 == null && p2 != null) || (p1 != null && p2 == null)){
            return "redirect:/relationships/edit?id="+id;
        }

        rel_mod.setName(nombre);
        rel_mod.setProd1(p1);
        rel_mod.setProd2(p2);

        relacionRepository.save(rel_mod);
        model.addAttribute("relaciones", relacionRepository.findAllByCuenta(usuario.getCuenta()));

        return "Relationship/listRelationship";
    }
}

