package rollerspeed.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// La anotación @Configuration indica a Spring que esta clase contiene definiciones de beans de configuración
@Configuration
public class OpenApiConfig {

    // Registramos un bean OpenAPI para personalizar los metadatos globales que muestra Swagger UI
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST - Escuela de Patinaje Roller Speed")
                        .version("1.0.0")
                        .description("Documentación oficial de los servicios web y endpoints desarrollados para automatizar la gestión de alumnos, aspirantes y procesos institucionales[cite: 1].")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo de Software")
                                .email("soporte@rollerspeed.local")
                                .url("https://github.com/felipebejarano/rollerspeed")));
    }
}