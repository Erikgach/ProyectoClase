package org.una.tramites;


import static io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation.HEADER;
import java.util.Collections;
import static java.util.Collections.singletonList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation.HEADER;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())))
                .securityContexts(singletonList(
                        SecurityContext.builder()
                                .securityReferences(
                                        singletonList(SecurityReference.builder()
                                                .reference("JWT")
                                                .scopes(new AuthorizationScope[0])
                                                .build()
                                        )
                                )
                                .build())
                )
                .select()
                .apis(
                        RequestHandlerSelectors
                                .basePackage("org.una.tramites.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Seguridad", "Metodos de Seguridad"),

                        new Tag("Usuarios", "Entidad de Usuarios"),
                        new Tag("Permisos Otorgados", "Entidad de Permisos Otorgados"),
                        new Tag("Permisos", "Entidad de Permisos"),
                        new Tag("Transacciones", "Entidad de Transacciones"),
                        new Tag("Departamentos", "Entidad de Departamento"),
                        new Tag("Clientes", "Entidad de Cliente"),
                        new Tag("Notas", "Entidad de Notas "),
                        new Tag("Requisitos", "Entidad de Requisito"),
                        new Tag("Requisito Presentado", "Entidad de Requisito presentado"),
                        new Tag("Tramites Estados", "Entidad de Tramites Estados"),
                        new Tag("Tramites Registrados", "Entidad de Tramites Registrados"),
                        new Tag("Tramites Tipos", "Entidad de Tramites Tipos"),
                        new Tag("Variaciones", "Entidad de Variaciones"),
                        new Tag("Archivos Relacionados", "Entidad de Archivos Relacionados"),
                        new Tag("Parametros Generales", "Entidad de Parametros Generales")


                );

    }




    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Trámites Municipales",
                "Rest API sobre Trámites Municipales.",
                "Versión:2.1.0",
                "https://google.com",
                new Contact("UNA Sede Región Brunca", "https://srb.una.ac.cr/index.php/es/", "decanatosrb@una.cr"),
                "Apache-2.0", "http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
    }
}
