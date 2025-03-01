package com.mateo.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import io.swagger.v3.oas.models.OpenAPI;

@ExtendWith(MockitoExtension.class)
public class SwaggerConfigTest {
	
	@InjectMocks
	private SwaggerConfig swaggerConfig;
	
	@Test
	public void testCustomeOpenAPI() {
		OpenAPI openAPI = swaggerConfig.customeOpenAPI();
		assertNotNull(openAPI);
	}

}
