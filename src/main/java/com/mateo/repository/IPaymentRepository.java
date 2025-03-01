package com.mateo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mateo.model.Payment;

/**
 * Description: Interface that defines the methods for managing the payment table
 * @author Juan Mateo
 *
 */
@Repository
public interface IPaymentRepository extends CrudRepository<Payment, Integer> {

}
