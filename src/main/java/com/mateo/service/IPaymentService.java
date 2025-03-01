package com.mateo.service;

import com.mateo.exception.DataException;
import com.mateo.model.Payment;
import com.mateo.model.Status;

/**
 * Description: Interface that defines business rules for payments
 * @author Juan Mateo
 *
 */
public interface IPaymentService {
	
	/**
	 * Method that stores a payment in the database
	 * @param payment to store 
	 */
	public void savePayment(Payment payment);
	
	/**
	 * Method that obtains the status of a payment
	 * @param id of payment
	 * @return status description
	 * @throws DataException If payment is not found
	 */
	public String getStatusPayment(Integer id) throws DataException;
	
	/**
	 * Method that updates the status of a payment
	 * @param idPayment Payment ID
	 * @param status new status
	 * @throws DataException If payment is not found
	 */
	public void updateStatusPayment(Integer idPayment, Status status) throws DataException;

}
