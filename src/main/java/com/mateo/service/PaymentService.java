package com.mateo.service;

import org.springframework.stereotype.Service;

import com.mateo.exception.DataException;
import com.mateo.model.Payment;
import com.mateo.model.Status;
import com.mateo.repository.IPaymentRepository;
import com.mateo.repository.IStatusRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: Class that implements the interface IPaymentService
 * @author Juan Mateo
 *
 */
@Slf4j
@Service
public class PaymentService implements IPaymentService {

	/***
	 * Dependency Injection IPaymentRepository
	 */
	private final IPaymentRepository paymentRepository;

	/***
	 * Dependency Injection IStatusRepository
	 */
	private final IStatusRepository statusRepository;

	/***
	 * Dependency Injection IKafkaProducerService
	 */
	private final IKafkaProducerService kafkaProducerService;
	
	/**
	 * Contructor method
	 * @param paymentRepository repository for payment
	 * @param statusRepository repository for status payment
	 * @param kafkaProducerService service for kafka producer
	 */
	public PaymentService(IPaymentRepository paymentRepository, IStatusRepository statusRepository, IKafkaProducerService kafkaProducerService) {
		this.paymentRepository = paymentRepository;
		this.statusRepository = statusRepository;
		this.kafkaProducerService = kafkaProducerService;
	}

	/**
	 * Method that stores a payment in the database
	 * @param payment to store 
	 */
	@Override
	public void savePayment(Payment payment) {
		log.info("Storing payment...");
		paymentRepository.save(payment);
	}

	/**
	 * Method that obtains the status of a payment
	 * @param id of payment
	 * @return status description
	 * @throws DataException If payment is not found
	 */
	@Override
	public String getStatusPayment(Integer id) throws DataException {
		log.info("Getting payment status...");
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new DataException("Payment not found."));
		
		return payment.getStatus().getDescription();
	}

	/**
	 * Method that updates the status of a payment
	 * @param idPayment Payment ID
	 * @param status new status
	 * @throws DataException If payment is not found
	 */
	@Override
	public void updateStatusPayment(Integer idPayment, Status status) throws DataException {
		log.info("Updating payment status...");
		Payment payment = paymentRepository.findById(idPayment)
				.orElseThrow(() -> new DataException("Payment not found."));

		Status statusFound = statusRepository.findById(status.getStatusId())
				.orElseThrow(() -> new DataException("Status not found."));

		payment.setStatus(statusFound);
		paymentRepository.save(payment);
		kafkaProducerService.sendMessage("Se modifica estatus del pago a " + statusFound.getDescription());

	}

}
