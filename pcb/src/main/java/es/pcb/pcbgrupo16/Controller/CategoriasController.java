package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Usuario;
import es.pcb.pcbgrupo16.Repository.CategoriaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
