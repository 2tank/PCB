package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.AtributoRepository;

import es.pcb.pcbgrupo16.Repository.ContenidoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/atributes")
public class AtributoController extends BaseController {

    @Autowired
    public AtributoRepository atributoRepository;

    @Autowired
    public ContenidoRepository contenidoRepository;



    @GetMapping("/")
    public String listarAtributos(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();

        List<Atributo> listaAtributos = atributoRepository.findAllByCuenta(cuenta);

        model.addAttribute("atributos", listaAtributos);

        return "Atributes/listAtributes";
    }

    @GetMapping("/delete")
    public String eliminarAtributo(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        contenidoRepository.deleteByAtributo(id);
        atributoRepository.deleteById(id);

//        List<Atributo> listaAtributos = atributoRepository.findAll();
//        model.addAttribute("atributos", listaAtributos);
//        return "Atributes/listAtributes";
        return "redirect:/atributes/";
    }

    @GetMapping("/create")
    public String crearAtributo(Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        Cuenta cuenta = usuario.getCuenta();

        return "Atributes/createAtributes";
    }

    @PostMapping("/create")
    public String crearAtributo(@RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        Cuenta cuenta = usuario.getCuenta();

        Atributo atributo = new Atributo();

        atributo.setNombre(nombre);
        atributo.setTipo(tipo);


        atributo.setCuent(cuenta);

        atributoRepository.save(atributo);

        model.addAttribute("atributos", atributoRepository.findAll());
        return "Atributes/listAtributes";
    }

    @GetMapping("/edit")
    public String editarAtributo(Model model, HttpSession session, @RequestParam("id") int id) {
        model.addAttribute("atributo", atributoRepository.findById(id).orElse(null));
        return "Atributes/editAtributes";
    }

    @PostMapping("/edit")
    public String editarAtributo(@RequestParam("id") int id, @RequestParam("nombre") String nombre, @RequestParam("tipo") String tipo, Model model, HttpSession session) {
        //TODO TERMINAR (LAS MANOS HACIA ARRIBA, LAS MANOS HACIA ABAJO Y COMO LOS GORILAS UUU UUU UUU)
        Atributo atributoMod = (Atributo) atributoRepository.findById(id).orElse(null);
        Atributo a = atributoMod;

        Contenido cont = new Contenido();
        contenidoRepository.save(cont);
        cont = contenidoRepository.findAll().getLast();

        atributoMod.setNombre(nombre);
        atributoMod.setTipo(tipo);

        atributoRepository.delete(a);
        atributoRepository.save(atributoMod);
        model .addAttribute("atributos", atributoRepository.findAll());
        return "Atributes/listAtributes";
    }

    @GetMapping("/view")
    public String viewAtributo(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        // Buscar el atributo por ID
        Atributo atributo = atributoRepository.findById(id).orElse(null);

        // Verificar si el atributo existe
        if (atributo == null) {
            model.addAttribute("error", "El atributo no existe.");
            return "Atributes/errorAtributo";
        }

        // Pasar los datos del atributo al modelo
        model.addAttribute("atributo", atributo);


        // Retornar la vista con las especificaciones
        return "Atributes/viewAtributes";

    }

}
