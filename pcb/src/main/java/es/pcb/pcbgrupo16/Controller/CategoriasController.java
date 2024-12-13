package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.CategoriaRepository;
import es.pcb.pcbgrupo16.Repository.ProductoCategoriaRepository;
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

    @Autowired
    private ProductoCategoriaRepository productoCategoriaRepository;

    // hay que asociar cuenta a categoria?
    @GetMapping("/")
    public String listarCategorias(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        for(Categoria c : listaCategorias) {
            List<Productocategoria> productocategoria = productoCategoriaRepository.findByIdIdCategoria(c.getId());
            c.setNumProductos(productocategoria.size());
        }

        model.addAttribute("categorias", listaCategorias);

        return "Categories/listCategories";
    }

    @GetMapping("/delete")
    public String eliminarcategoria(Model model, HttpSession session, @RequestParam("id") Integer id) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        if (usuario == null || usuario.getCuenta() == null) {
            return "redirect:/login";
        }

        Categoria categoria = categoriaRepository.findById(id).get();
        productoCategoriaRepository.deleteByIdCategoria(id);
        categoriaRepository.delete(categoria);
        categoriaRepository.flush();

        return "redirect:/categories/";
    }

    @GetMapping("/create")
    public String crearCategoriasForm(Model model, HttpSession session) {
        return "Categories/createCategories";
    }

    @PostMapping("/create")
    public String crearCategorias(Model model, HttpSession session, @RequestParam("category") String category) {
        Cuenta c = ((Usuario)session.getAttribute("usuarioSesion")).getCuenta();
        Categoria categoria = new Categoria();
        categoria.setNombre(category);
        categoria.setCuenta(c);
        categoriaRepository.save(categoria);

        return "redirect:/categories/";
    }

    @GetMapping("/edit")
    public String editarCategorias(Model model, HttpSession session, @RequestParam("id") int id) {
        model.addAttribute("categoria", categoriaRepository.findById(id).orElse(null));
        return "Categories/editCategories";
    }

    @PostMapping("/edit")
    public String editarCategorias(@ModelAttribute Categoria categoria, Model model, HttpSession session) {

        categoriaRepository.save(categoria);

        return "redirect:/categories/";
    }




}
