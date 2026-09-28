package rollerspeed.controller;

import rollerspeed.modelo.Alumno;
import rollerspeed.servicio.AlumnoService;  
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Indica que esta clase es un controlador REST (retorna JSON en lugar de vistas HTML)
@RestController
// Define la ruta base para todos los endpoints de esta API
@RequestMapping("/api/alumnos")
// Agrupa y describe este controlador visualmente en la interfaz de Swagger UI
@Tag(name = "Alumnos API", description = "Operaciones y recursos de la API REST para la gestión de alumnos y aspirantes de Roller Speed")
public class AlumnoRestController {

    // Inyectamos la capa de servicio creada en etapas anteriores
    @Autowired
    private AlumnoService alumnoService;

    // ===================================================================
    // ENDPOINT 1: LISTAR TODOS LOS ALUMNOS
    // ===================================================================
    @Operation(summary = "Listar todos los alumnos", description = "Retorna una lista con todos los alumnos e inscritos registrados en la base de datos.")
    @ApiResponse(responseCode = "200", description = "Lista obtenida exitosamente en formato JSON")
    @GetMapping
    public List listarAlumnos() {
        return alumnoService.listarTodos();
    }

    // ===================================================================
    // ENDPOINT 2: REGISTRAR UN NUEVO ASPIRANTE VÍA API
    // ===================================================================
    @Operation(summary = "Registrar un nuevo aspirante", description = "Crea un nuevo registro de alumno asignando automáticamente el rol de Alumno sin intervención manual.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Aspirante registrado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta o correo ya registrado")
    })
    @PostMapping
    public ResponseEntity registrarAspirante(@RequestBody Alumno alumno) {
        // Validamos si el correo ya existe en la base de datos
        if (alumnoService.existePorCorreo(alumno.getCorreo())) {
            return ResponseEntity.badRequest().build();
        }
        // Guardamos el alumno usando el servicio
        Alumno nuevoAlumno = alumnoService.registrarAspirante(alumno);
        return ResponseEntity.status(201).body(nuevoAlumno);
    }

    // ===================================================================
    // ENDPOINT 3: BUSCAR ALUMNO POR ID
    // ===================================================================
    @Operation(summary = "Buscar alumno por ID", description = "Permite consultar la información detallada de un alumno específico mediante su identificador único.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Alumno encontrado con éxito"),
        @ApiResponse(responseCode = "404", description = "El alumno con el ID especificado no existe")
    })
    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        Optional alumno = alumnoService.buscarPorId(id);
        if (alumno.isPresent()) {
            return ResponseEntity.ok(alumno.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

