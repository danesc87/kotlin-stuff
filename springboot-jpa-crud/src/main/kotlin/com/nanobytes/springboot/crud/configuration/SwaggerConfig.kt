package com.nanobytes.springboot.crud.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Class that enables Swagger and Swagger-UI, also will comment only the endpoints
 * that are located on controller package
 * @author Daniel Córdova A.
 */
@EnableSwagger2
@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nanobytes.springboot.crud.controller"))
                .paths(PathSelectors.any())
                .build()
    }
}