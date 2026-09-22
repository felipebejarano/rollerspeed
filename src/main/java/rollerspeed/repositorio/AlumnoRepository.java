package rollerspeed.repositorio;

import rollerspeed.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// La anotación @Repository le indica a Spring que esta interfaz gestiona operaciones de base de datos
@Repository
// Extendemos de JpaRepository especificando la Entidad (Alumno) y el tipo de dato de su ID (Long).
// Esto nos brinda automáticamente métodos CRUD (save, findAll, findById, deleteById) sin escribir SQL.
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    // Método personalizado opcional: permite buscar si ya existe un alumno por su correo
    boolean existsByCorreo(String correo);
}