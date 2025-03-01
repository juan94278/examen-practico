package com.mateo.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mateo.model.ResponseGeneric;

@ExtendWith(MockitoExtension.class)
public class GlobalExceptionTest {

	@InjectMocks
	private GlobalException controllerAdviceException;

	@Test
	public void testErrorHandlerDataException() {
		DataException dataException = mock(DataException.class);

		ResponseEntity<ResponseGeneric> response = controllerAdviceException.errorHandler(dataException);
		assertNotNull(response);
	}
	
	@Test
	public void testErrorHandlerNumberFormatException() {
		NumberFormatException numberFormatException = mock(NumberFormatException.class);

		ResponseEntity<ResponseGeneric> response = controllerAdviceException.errorHandler(numberFormatException);
		assertNotNull(response);
	}
	
	@Test
	public void testErrorHandlerException() {
		Exception exception = mock(Exception.class);

		ResponseEntity<ResponseGeneric> response = controllerAdviceException.errorHandler(exception);
		assertNotNull(response);
	}

}
