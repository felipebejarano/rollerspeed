// Paquete donde se ubica nuestra clase controller
package rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    // Maneja la raíz 
    @GetMapping("/")
    public String index() {
        return "index"; // Retorna el archivo index.html en templates
    }

    // Maneja de Misión
    @GetMapping("/mision")
    public String mision() {
        return "mision"; // Retorna mision.html
    }

    // Maneja de Visión
    @GetMapping("/vision")
    public String vision() {
        return "vision"; // Retorna vision.html
    }

    // Maneja de Valores
    @GetMapping("/valores")
    public String valores() {
        return "valores"; // Retorna valores.html
    }

    // Maneja  de Servicios
    @GetMapping("/servicios")
    public String servicios() {
        return "servicios"; // Retorna servicios.html
    }

    // Maneja de Eventos
    @GetMapping("/eventos")
    public String eventos() {
        return "eventos"; // Retorna eventos.html
    }
}