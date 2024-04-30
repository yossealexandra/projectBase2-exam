package com.projectbase2.exam.student.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title="Exam Project Base2",
                version="0.0.1",
                description = "Proyecto base Examen Base2",
                termsOfService = "http://swagger.io/terms/"
        )
)
public class OpenApiConfig {


}
