package com.mateo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * Description: Configuration class to document with swagger
 * @author Juan Mateo
 *
 */
@Configuration
public class SwaggerConfig {
	
	/**
	 * Bean that defines service information
	 * @return <OpenAPI>
	 */
	@Bean
	public OpenAPI customeOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Examen práctico"));
	}

}
