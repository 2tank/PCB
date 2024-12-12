package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.Entities.*;
import es.pcb.pcbgrupo16.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import es.pcb.pcbgrupo16.Repository.CuentaRepository;

@Controller
public class Home extends BaseController{

    @Autowired
    private CuentaRepository cuentaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/")
    public String login(Model model, HttpSession session) {

        String webRedirect = "Home/Login";
        if(estaAutenticado(session)) {
            Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");

//            if(cuenta.getEsAgente()){
//                webRedirect = "/agente";
//            }else if(cuenta.getEsOwner()){
//                webRedirect = "/owner";
//            }else if(cuenta.getEsUsuario()){
//                webRedirect = "Home";
//            }else{
//                session.invalidate();
//                webRedirect = "Home/Login";
//            }
         }

        return webRedirect;
    }

    @PostMapping("/auth")
    public String autenticar(Model model, HttpSession session, @RequestParam String username, @RequestParam String password) {

        Usuario usuario = (Usuario) usuarioRepository.findByNombreAndContrasena(username, password);

        if (usuario != null) {
            // Guardar la cuenta en la sesión
            session.setAttribute("usuarioSesion", usuario);
            Cuenta cuenta = (Cuenta) usuario.getCuenta();
            model.addAttribute("cuenta", cuenta);
            return "Home/Home";
        }

        model.addAttribute("error", "Nombre de usuario o contraseña incorrectos.");
        return "login";
    }

}
