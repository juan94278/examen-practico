package com.mateo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatusTest {
	
	@Test
	public void testConstructor() {
		final Integer statusId = 1;
		final String description = "Iniciado";
		
		Status status = new Status();
		status.setStatusId(statusId);
		status.setDescription(description);
		
		assertEquals(status.getStatusId(), statusId);
		assertEquals(status.getDescription(), description);
	}

}
