package rollerspeed.servicio;

import rollerspeed.modelo.Alumno;
import rollerspeed.repositorio.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service indica que esta clase contiene la lógica de negocio de la aplicación
@Service
public class AlumnoServiceImpl implements AlumnoService {

    // Inyección de dependencias para acceder a los métodos del repositorio JPA
    @Autowired
    private AlumnoRepository alumnoRepository;

    // Regla de negocio: Registra al aspirante asignándole de forma automática el rol "Alumno"[cite: 1]
    @Override
    public Alumno registrarAspirante(Alumno alumno) {
        // Garantizamos que el rol por defecto sea "Alumno" antes de guardar en MySQL[cite: 1]
        if (alumno.getRol() == null || alumno.getRol().isEmpty()) {
            alumno.setRol("Alumno");
        }
        // Guardamos el objeto en la base de datos
        return alumnoRepository.save(alumno);
    }

    // Retorna la lista de todos los alumnos guardados en la BD
    @Override
    public List<Alumno> listarTodos() {
        return alumnoRepository.findAll();
    }

    // Busca un alumno por su ID relacional
    @Override
    public Optional<Alumno> buscarPorId(Long id) {
        return alumnoRepository.findById(id);
    }

    // Verifica la existencia previa de un correo electrónico
    @Override
    public boolean existePorCorreo(String correo) {
        return alumnoRepository.existsByCorreo(correo);
    }
}
