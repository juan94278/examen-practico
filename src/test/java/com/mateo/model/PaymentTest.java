package com.mateo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentTest {
	
	@Test
	public void testConstructor() {
		final Integer id = 1;
		final String concept = "Moto";
		final int quantityProduct = 1;
		final String shippingPerson = "Juan";
		final String depositPerson = "Raquel";
		final double amount = 3000.00;
		final Status status = new Status();
		
		Payment payment = new Payment();
		payment.setId(id);
		payment.setConcept(concept);
		payment.setQuantityProduct(quantityProduct);
		payment.setShippingPerson(shippingPerson);
		payment.setDepositPerson(depositPerson);
		payment.setAmount(amount);
		payment.setStatus(status);
		
		assertEquals(payment.getId(), id);
		assertEquals(payment.getConcept(), concept);
		assertEquals(payment.getQuantityProduct(), quantityProduct);
		assertEquals(payment.getShippingPerson(), shippingPerson);
		assertEquals(payment.getDepositPerson(), depositPerson);
		assertEquals(payment.getAmount(), amount);
		assertEquals(payment.getStatus(), status);
	}

}
