package com.mateo.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DataExceptionTest {
	
	@Test
	public void testConstructor() {
		
		DataException dataException = new DataException("Not found");
		DataException dataException2 = new DataException("Not found", new Throwable());
		
		assertNotNull(dataException);
		assertNotNull(dataException2);
		
	}

}
