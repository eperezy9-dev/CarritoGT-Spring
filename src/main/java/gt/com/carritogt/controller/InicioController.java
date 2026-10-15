package gt.com.carritogt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InicioController {
    @GetMapping("/salud")
    public String verificarSalud() {
        return "La API de CarritoGT funciona correctamente";
    }
}
