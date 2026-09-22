package rollerspeed.modelo;
import jakarta.persistence.*;
import java.time.LocalDate;

// Se indica a Spring JPA que esta clase representa una tabla en la base de datos
@Entity
// Se define el nombre exacto de la tabla en MySQL
@Table(name = "alumnos")
public class Alumno {

    // Se define la clave primaria (ID) de la tabla
    @Id
    //Se configura el ID para que sea autoincrementable en MySQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nombre completo del alumno o aspirante
    @Column(nullable = false, length = 100)
    private String nombre;

    // Fecha de nacimiento para control de niveles y categorías
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    // Género del alumno
    @Column(nullable = false, length = 20)
    private String genero;

    // Correo electrónico (utilizado para contacto y login futuro)
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    // Número de teléfono de contacto
    @Column(nullable = false, length = 20)
    private String telefono;

    // Medio de pago seleccionado durante el registro (PSE, Tarjeta, Efectivo)
    @Column(name = "medio_pago", nullable = false, length = 50)
    private String medioPago;

    // Rol asignado dentro del sistema (por defecto "Alumno")
    @Column(nullable = false, length = 30)
    private String rol = "Alumno";

    // Constructor vacío exigido por JPA
    public Alumno() {
    }

    // Constructor con parámetros para instanciar objetos fácilmente
    public Alumno(String nombre, LocalDate fechaNacimiento, String genero, String correo, String telefono, String medioPago) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.medioPago = medioPago;
        this.rol = "Alumno"; // Asignación automática del rol
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}