package rollerspeed.servicio;

import rollerspeed.modelo.Alumno;

import java.util.List;
import java.util.Optional;

// Define los métodos de negocio disponibles para la gestión de alumnos y aspirantes
public interface AlumnoService {

    // Registra un nuevo aspirante asignando automáticamente su rol[cite: 1]
    Alumno registrarAspirante(Alumno alumno);

    // Obtiene el listado completo de alumnos registrados
    List<Alumno> listarTodos();

    // Busca un alumno específico por su ID de registro
    Optional<Alumno> buscarPorId(Long id);

    // Verifica si un correo ya se encuentra registrado en el sistema
    boolean existePorCorreo(String correo);
}
