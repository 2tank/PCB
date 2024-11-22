package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.Atributo;
import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Usuario;
import es.pcb.pcbgrupo16.Repository.AtributoRepository;
import es.pcb.pcbgrupo16.Repository.AtributoUsuarioRepository;
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
    public AtributoUsuarioRepository atributoUsuarioRepository;


    @GetMapping("/")
    public String listarProductos(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Atributo> listaAtributos = atributoRepository.findAll();

        model.addAttribute("atributos", listaAtributos);

        return "Atributes/listAtributes";
    }

    @GetMapping("/delete")
    public String eliminarcategoria(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        atributoUsuarioRepository.deleteAtributoById(id);
        atributoRepository.deleteById(id);

        List<Atributo> listaAtributos = atributoRepository.findAll();
        model.addAttribute("atributos", listaAtributos);
        return "Atributes/listAtributes";
    }

    @GetMapping("/create")
    public String crearCategorias(Model model, HttpSession session) {
        return "Atributes/createAtributes";
    }

    @PostMapping("/create")
    public String crearCategorias(@ModelAttribute Categoria categoria, Model model, HttpSession session) {
        return "Atributes/listAtributes";
    }

    @GetMapping("/edit")
    public String editarCategorias(Model model, HttpSession session, @RequestParam("id") int id) {
        model.addAttribute("atributo", atributoRepository.findById(id).orElse(null));
        return "Atributes/createAtributes";
    }

    @PostMapping("/edit")
    public String editarCategorias(@ModelAttribute Categoria categoria, Model model, HttpSession session) {
        return "Atributes/listAtributes";
    }
//    @Autowired
//    private AtributoService atributoService;
//
//
//    @GetMapping
//    public List<AtributoUsuario> listarAtributos(){
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
