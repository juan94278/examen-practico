package com.mateo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResponseGenericTest {

	@Test
	public void testConstructor() {
		final Object data = null;
		final String error = "Not found";
		
		ResponseGeneric generic = new ResponseGeneric();
		
		generic.setData(data);
		generic.setError(error);
		
		assertEquals(generic.getData(), data);
		assertEquals(generic.getError(), error);
	}
	
}
