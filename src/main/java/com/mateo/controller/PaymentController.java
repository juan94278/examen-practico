package com.mateo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mateo.exception.DataException;
import com.mateo.model.Payment;
import com.mateo.model.ResponseGeneric;
import com.mateo.model.Status;
import com.mateo.service.IPaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * Description: Controller class that defines the endpoints for the payment service
 * @author Juan Mateo
 *
 */
@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

	/***
	 * Dependency Injection IPaymentService
	 */
	private final IPaymentService paymentService;
	
	/**
	 * Constructor method
	 * @param paymentService service for payment
	 */
	public PaymentController(IPaymentService paymentService) {
		this.paymentService = paymentService;
	}

	/**
	 * Enpoint that stores a payment
	 * @param payment data
	 * @return <ResponseEntity>
	 */
	@Operation(summary = "Almacenar pago", description = "Almacena un pago con un estatus inicial.", responses = {
			@ApiResponse( responseCode = "201", content = @Content(schema = @Schema(implementation = ResponseGeneric.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
			})
	@PostMapping
	public ResponseEntity<ResponseGeneric> savePayment(@RequestBody Payment payment) {

		paymentService.savePayment(payment);

		ResponseGeneric generic = new ResponseGeneric();
		generic.setData("SUCCESS");

		return new ResponseEntity<>(generic, HttpStatus.CREATED);
	}

	/**
	 * Enpoint to get the status of a payment
	 * @param id Payment ID
	 * @return <ResponseEntity>
	 */
	@Operation(summary = "Obtener estatus", description = "Obtiene el estatus de un pago.", responses = {
			@ApiResponse( responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseGeneric.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse( responseCode = "500", description = "Controlled error", content = @Content(schema = @Schema(implementation = ResponseGeneric.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
			})
	@GetMapping(path = "/status")
	public ResponseEntity<ResponseGeneric> getStatusPayment(@RequestParam String id)
			throws NumberFormatException, DataException {

		ResponseGeneric generic = new ResponseGeneric();

		generic.setData(paymentService.getStatusPayment(Integer.parseInt(id)));

		return new ResponseEntity<ResponseGeneric>(generic, HttpStatus.OK);
	}

	/**
	 * Endpoint to change the status of a payment
	 * @param idPayment Payment ID
	 * @param status to change
	 * @return <ResponseEntity>
	 * @throws DataException controlled
	 */
	@Operation(summary = "Cambiar estatus", description = "Actualiza el estatus de un pago.", responses = {
			@ApiResponse( responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseGeneric.class), mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse( responseCode = "500", description = "Controlled error", content = @Content(schema = @Schema(implementation = ResponseGeneric.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
			})
	@PutMapping(path = "/status/{idPayment}")
	public ResponseEntity<ResponseGeneric> updateStatusPayment(@PathVariable int idPayment, @RequestBody Status status)
			throws DataException {

		ResponseGeneric generic = new ResponseGeneric();

		paymentService.updateStatusPayment(idPayment, status);

		generic.setData("SUCCESS");

		return new ResponseEntity<ResponseGeneric>(generic, HttpStatus.OK);

	}

}
