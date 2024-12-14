package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/exports")
public class ExportController extends BaseController{


    @Autowired
    public AtributoRepository atributoRepository;

    @Autowired
    public CategoriaRepository categoriaRepository;

    @Autowired
    public ProductoCategoriaRepository productoCategoriaRepository;

    @Autowired
    public ProductoRepository productoRepository;
    @Autowired
    private ContenidoRepository contenidoRepository;

    @GetMapping("/")
    public String menuExportacion(Model model, HttpSession session) {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();

        List<Categoria> categorias = categoriaRepository.findAllByCuenta(cuenta);

        for(Categoria c : categorias) {
            List<Productocategoria> productocategoria = productoCategoriaRepository.findByIdIdCategoria(c.getId());
            c.setNumProductos(productocategoria.size());
        }

        List<Producto> productos = productoRepository.findAllByCuenta(cuenta.getId());

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);

        return "Export/createExport";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam("atributoId") Integer atributoId, Model model, HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();

        List<Productocategoria> productocategorias = productoCategoriaRepository.findByIdIdCategoria(atributoId);

        List<Producto> productos = new ArrayList<>();

        for(Productocategoria p : productocategorias) {
            productos.add(productoRepository.findById(p.getId().getIdProducto()).orElse(null));
        }

        List<Categoria> categorias = categoriaRepository.findAllByCuenta(cuenta);

        for(Categoria c : categorias) {
            List<Productocategoria> productocategoria = productoCategoriaRepository.findByIdIdCategoria(c.getId());
            c.setNumProductos(productocategoria.size());
        }

        model.addAttribute("categorias", categorias);
        model.addAttribute("productos", productos);

        return "Export/createExport";
    }

    @PostMapping("/create")
    public String create(@RequestParam("productosSeleccionados") List<Integer> productosSeleccionados,
                         Model model, HttpSession session, HttpServletResponse response) throws IOException {

        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        Atributo atributoSeleccionado = atributoRepository.findByCuentaAndIntegerOrDouble(cuenta.getId());

        if (atributoSeleccionado != null) {
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"productos.csv\"");

            StringBuilder csvBuilder = new StringBuilder();
            csvBuilder.append("SKU,Title,Fulfilled By,Amazon_SKU,Price,Offer Primer\n");
            try (ICsvListWriter csvWriter = new CsvListWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE)) {

                String[] encabezados = {"SKU", "Title", "Fulfilled By", "Amazon_SKU", "Price", "Offer Primer"};
                csvWriter.writeHeader(encabezados);


                for (Integer i : productosSeleccionados) {

                    Producto p = productoRepository.findById(i).orElse(null);
                    Contenido contenido = contenidoRepository.findByAtributoAndId(atributoSeleccionado.getId(), i);

                    String nombreProducto = p.getNombre();
                    String nombreCuenta = cuenta.getNombre();
                    Integer gtin = p.getGtin();
                    String contenidoString = contenido.getContenido();
                    boolean offerPrimer = false;

                    csvWriter.write(Arrays.asList(i, nombreProducto, nombreCuenta, gtin, contenidoString, offerPrimer));

                    csvBuilder.append(i)
                            .append(",")
                            .append(nombreProducto)
                            .append(",")
                            .append(nombreCuenta)
                            .append(",")
                            .append(gtin)
                            .append(",")
                            .append(contenidoString)
                            .append(",")
                            .append(offerPrimer)
                            .append("\n");
                }
                model.addAttribute("csv", csvBuilder.toString());
                return "Export/showCsv";
            }catch (IOException e) {
                model.addAttribute("error", "Error al generar el archivo CSV");
                return "redirect:/";
            }
        }
        else{
            return "redirect:/";
        }
    }

}
