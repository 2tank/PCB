package es.pcb.pcbgrupo16.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class BaseController {

    protected boolean estaAutenticado(HttpSession session) {
        return session.getAttribute("user") != null;
    }

}