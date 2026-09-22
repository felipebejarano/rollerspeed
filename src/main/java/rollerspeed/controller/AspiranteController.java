package rollerspeed.controller;
import rollerspeed.modelo.Alumno;
import rollerspeed.servicio.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registro")
public class AspiranteController {

    @Autowired
    private AlumnoService alumnoService;

    // Muestra el formulario de registro 
    @GetMapping
    public String mostrarFormularioRegistro(Model model) {
        // Pasamos un objeto Alumno vacío a la vista para vincular los campos del formulario Thymeleaf
        model.addAttribute("alumno", new Alumno());
        return "registro"; // Retorna la plantilla registro.html
    }

    // Recibe y procesa los datos del formulario (POST http://localhost:8080/registro)
    @PostMapping
    public String guardarAspirante(@ModelAttribute("alumno") Alumno alumno, Model model) {
        // Validar si el correo ya existe
        if (alumnoService.existePorCorreo(alumno.getCorreo())) {
            model.addAttribute("error", "El correo ingresado ya se encuentra registrado.");
            return "registro";
        }

        // Guarda al aspirante asignándole automáticamente el rol de Alumno
        alumnoService.registrarAspirante(alumno);

        // Redirige al formulario mostrando un parámetro de éxito
        return "redirect:/registro?exito";
    }
}
