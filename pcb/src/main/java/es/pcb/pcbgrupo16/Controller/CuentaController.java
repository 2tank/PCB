package es.pcb.pcbgrupo16.Controller;


import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.JSONObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequestMapping("/account")
public class CuentaController extends BaseController{
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AtributoRepository atributoRepository;

    @Autowired
    private RelacionRepository relacionRepository;

    @GetMapping("/view")
    public String viewCuenta(Model model, HttpSession session, @RequestParam("id") Integer id){
        //MOSTRAR EL NOMBRE DE LA CUENTA
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();//Cogemos la cuenta
        model.addAttribute("nombreCuenta",cuenta.getNombre());
        //MOSTRAR EL NUMERO DE PRODUCTOS QUE HAY
        List<Producto> productos = productoRepository.findAllByCuenta(cuenta.getId());
        model.addAttribute("numeroProductos",productos.size());
        //MOSTRAR EL NUMERO DE ATRIBUTOS QUE HAY
        List<Atributo> atributos = atributoRepository.findAllByCuenta(cuenta);
        model.addAttribute("numeroAtributos",atributos.size());
        //MOSTRAR EL NUMERO DE CATEGORIAS QUE HAY
        List<Categoria> categorias = categoriaRepository.findAllByCuenta(cuenta);
        model.addAttribute("numeroCategorias",categorias.size());
        //MOSTRAR EL NUMERO DE RELACIONES QUE HAY
        List<Relacion> relaciones = relacionRepository.findAllByCuenta(cuenta);
        model.addAttribute("numeroRelaciones",relaciones.size());
        //MOSTRAR EL TIPO DE SUSCRIPCION
        model.addAttribute("tipoSuscripcion",cuenta.getTipoSuscripcion());
        return "Account/viewAccount";
    }

    @ResponseBody
    @GetMapping("/export")
    public ResponseEntity<Resource> exportData(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuarioSesion");
        Cuenta cuenta = usuario.getCuenta();
        List<Producto> productos = productoRepository.findAllByCuenta(cuenta.getId());
        List<Atributo> atributos = atributoRepository.findAllByCuenta(cuenta);
        List<Categoria> categorias = categoriaRepository.findAllByCuenta(cuenta);
        List<Relacion> relaciones = relacionRepository.findAllByCuenta(cuenta);

        JSONObject json = new JSONObject();

        json.put("Account Name", cuenta.getNombre());
        json.put("Number of Products",productos.size());
        json.put("Number of Attributes",atributos.size());
        json.put("Number of Categories",categorias.size());
        json.put("Number of Relationships ",relaciones.size());
        String tipoSuscripcion = "";
        switch (cuenta.getTipoSuscripcion()) {
            case 1 : tipoSuscripcion = "BASIC"; break;
            case 2 : tipoSuscripcion = "MEDIUM"; break;
            case 3 : tipoSuscripcion = "ENTERPRISE"; break;
            default : tipoSuscripcion = "SUBCRIPTION INVALID"; break;
        };
        json.put("Type of Subscription", tipoSuscripcion);

        // Convertir el JSON a bytes
        byte[] jsonBytes = json.toString().getBytes(StandardCharsets.UTF_8);

        // Crear un recurso para el archivo
        ByteArrayResource resource = new ByteArrayResource(jsonBytes);

        // Configurar encabezados HTTP para forzar la descarga
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=export.json");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

        // Devolver la respuesta con el archivo
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(jsonBytes.length)
                .body(resource);
    }

}
