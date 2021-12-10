package br.com.projects.hotelreservationservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.projects.hotelreservationservice.controllers"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
          "HOTEL RESERVATION SERVICE API", 
          "Simple Spring Boot REST API from hotel reservation.", 
          "v1", 
          "https://www.apache.org/licenses/LICENSE-2.0", 
          new Contact("André Gustavo", "https://github.com/andrehgustavo", "andreh_gustavo@hotmail.com"), 
          "License of API", "API license URL", Collections.emptyList());
    }
}
