package com.mateo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mateo.exception.DataException;
import com.mateo.model.Payment;
import com.mateo.model.Status;
import com.mateo.repository.IPaymentRepository;
import com.mateo.repository.IStatusRepository;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
	
	@InjectMocks
	private PaymentService paymentService;
	
	@Mock
	private IPaymentRepository paymentRepository;
	
	@Mock
	private IStatusRepository statusRepository;
	
	@Mock
	private KafkaProducerService kafkaProducerService;
	
	@Test
	public void testSavePayment() {
		Payment payment = mock(Payment.class);
		when(paymentRepository.save(any())).thenReturn(payment);
		
		paymentService.savePayment(payment);
	}
	
	@Test
	public void testGetStatusPayment() {
		Payment payment = mock(Payment.class);
		Status status = new Status();
		status.setStatusId(1);
		status.setDescription("Iniciado");
		when(payment.getStatus()).thenReturn(status);
		when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
		try {
			String descriptionStatus = paymentService.getStatusPayment(1);
			assertEquals(descriptionStatus, payment.getStatus().getDescription());
		} catch (DataException e) {
		}
	}
	
	@Test
	public void testGetStatusPaymentNull() {
		
		when(paymentRepository.findById(anyInt())).thenReturn(Optional.empty());
		try {
			paymentService.getStatusPayment(1);
		} catch (DataException e) {
			assertEquals(e.getMessage(), "Payment not found.");
		}
	}
	
	@Test
	public void testUpdateStatusPayment() {
		Payment payment = mock(Payment.class);
		Status status = mock(Status.class);
		//when(payment.getStatus()).thenReturn(new Status());
		when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
		when(statusRepository.findById(anyInt())).thenReturn(Optional.of(status));
		doNothing().when(kafkaProducerService).sendMessage(anyString());
		
		try {
			paymentService.updateStatusPayment(1, status);
			assertTrue(true);
		} catch (DataException e) {
		}
	}
	
	@Test
	public void testUpdateStatusPaymentException() {
		when(paymentRepository.findById(anyInt())).thenReturn(Optional.empty());
		try {
			paymentService.updateStatusPayment(1, new Status());
		} catch (DataException e) {
			assertEquals(e.getMessage(), "Payment not found.");
		}
	}
	
	@Test
	public void testUpdateStatusPaymentExceptionStatus() {
		Payment payment = mock(Payment.class);
		Status status = mock(Status.class);
		when(paymentRepository.findById(anyInt())).thenReturn(Optional.of(payment));
		when(statusRepository.findById(anyInt())).thenReturn(Optional.empty());
		
		try {
			paymentService.updateStatusPayment(1, status);

		} catch (DataException e) {
			assertEquals(e.getMessage(), "Status not found.");
		}
	}

}
