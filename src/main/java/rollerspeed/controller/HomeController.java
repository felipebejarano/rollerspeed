// Paquete donde se ubica nuestra clase controller
package rollerspeed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class HomeController {

    // Maneja la raíz 
    @GetMapping("/")
    public String index() {
        return "index"; // Retorna el archivo index.html en templates
    }
    @GetMapping("/servicios")
    public String servicios(Model model) {
        // Creamos una lista de servicios para enviarla dinámicamente a la vista
        List<String> listaServicios = List.of(
            "Entrenamiento para principiantes",
            "Preparación para competencias",
            "Clases Recreativas de Patinaje",
            "Acondicionamiento Físico Especializado"
        );
        // Agregamos la lista al modelo de Thymeleaf
        model.addAttribute("servicios", listaServicios);
        return "servicios"; // Retorna la plantilla servicios.html
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

       // Maneja de Eventos
    @GetMapping("/eventos")
    public String eventos() {
        return "eventos"; // Retorna eventos.html
    }
}