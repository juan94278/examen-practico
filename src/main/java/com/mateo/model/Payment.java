package com.mateo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: Payment entity class
 * @author Juan Mateo
 *
 */
@Getter
@Setter
@Entity(name = "payments")
public class Payment implements Serializable {

	/**
	 * Payment id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_id")
	@Schema(name = "id", example = "1")
	private Integer id;
	
	/**
	 * Concept of payment
	 */
	@NotNull(message = "The concept is required")
	@Schema(name = "concept", example = "Car")
	private String concept;
	
	/**
	 * Quantity products
	 */
	@Column(name = "quantity_products")
	@Min(message = "The quantityProduct is required", value = 1)
	@Schema(name = "quantityProduct", example = "1")
	private int quantityProduct;
	
	/**
	 * Shipping person
	 */
	@Column(name = "shipping_person")
	@NotNull(message = "The shippingPerson is required")
	@Schema(name = "shippingPerson", example = "Juan")
	private String shippingPerson;
	
	/**
	 * Deposit person
	 */
	@Column(name = "deposit_person")
	@NotNull(message = "The depositPerson is required")
	@Schema(name = "depositPerson", example = "Raquel")
	private String depositPerson;
	
	/**
	 * Amount
	 */
	@NotNull(message = "The amount is required")
	@Schema(name = "amount", example = "200000.00")
	private double amount;
	
	/**
	 * Status of payment
	 */
	@ManyToOne
    @JoinColumn(name = "status")
	@NotNull(message = "The status is required")
	@Schema(name = "status")
	private Status status;
	
	/**
	 * @serial
	 */
	private static final long serialVersionUID = 3809702052779813039L;

}
