package com.example.futbol.Configuracion;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI()
                .info(new Info()
                        .title("API futbol")
                        .version("1.0")
                        .description("Documentacion de API futbol")
                        .contact(new Contact()
                                .name("Soporte API")
                                .email("dalejandrosarmiento@ucundinamarca.edu.co")));



    }

}