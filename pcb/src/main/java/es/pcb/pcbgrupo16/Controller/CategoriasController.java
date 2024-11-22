package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Producto;
import es.pcb.pcbgrupo16.Entities.Usuario;
import es.pcb.pcbgrupo16.Repository.CategoriaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoriasController extends BaseController{

    @Autowired
    private CategoriaRepository categoriaRepository;

    // hay que asociar cuenta a categoria?
    @GetMapping("/")
    public String listarCategorias(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        model.addAttribute("categorias", listaCategorias);

        return "Categories/listCategories";
    }

    @GetMapping("/delete")
    public String eliminarcategoria(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }
        categoriaRepository.deleteById(id);

        List<Categoria> listaCategories = categoriaRepository.findAll();
        model.addAttribute("categorias", listaCategories);
        return "Categories/listCategories";
    }

    @GetMapping("/create")
    public String crearCategorias(Model model, HttpSession session) {
        return "Categories/createCategories";
    }

    @PostMapping("/create")
    public String crearCategorias(@ModelAttribute Categoria categoria, Model model, HttpSession session) {
        return "Categories/listCategories";
    }

    @GetMapping("/edit")
    public String editarCategorias(Model model, HttpSession session, @RequestParam("id") int id) {
        model.addAttribute("categoria", categoriaRepository.findById(id).orElse(null));
        return "Categories/createCategories";
    }

    @PostMapping("/edit")
    public String editarCategorias(@ModelAttribute Categoria categoria, Model model, HttpSession session) {
        return "Categories/listCategories";
    }
}
