package com.mateo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mateo.exception.DataException;
import com.mateo.model.Payment;
import com.mateo.model.ResponseGeneric;
import com.mateo.model.Status;
import com.mateo.service.PaymentService;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {
	
	@InjectMocks
	private PaymentController paymentController;
	
	@Mock
	private PaymentService paymentService;
	
	@Test
	public void testSavePayment() {
		
		Payment payment = mock(Payment.class);
		doNothing().when(paymentService).savePayment(payment);
		ResponseEntity<ResponseGeneric> response = paymentController.savePayment(payment);
		assertEquals(response.getBody().getData(), "SUCCESS");
		
	}
	
	@Test
	public void testGetStatusPayment() {
		try {
			when(paymentService.getStatusPayment(1)).thenReturn("Inciiado");
			ResponseEntity<ResponseGeneric> response = paymentController.getStatusPayment("1");
			assertEquals(response.getBody().getData(), "Inciiado");
		} catch (NumberFormatException | DataException e) {
		}
	}
	
	@Test
	public void testUpdateStatusPayment() {
		
		Status status = mock(Status.class);
		try {
			doNothing().when(paymentService).updateStatusPayment(1, status);
			ResponseEntity<ResponseGeneric> response = paymentController.updateStatusPayment(1, status);
			assertEquals(response.getBody().getData(), "SUCCESS");
		} catch (DataException e) {
		}
		
		
		
	}

}
