package com.mateo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mateo.model.Status;

/**
 * Description: Interface that defines the methods for managing the status payment table
 * @author Juan Mateo
 *
 */
@Repository
public interface IStatusRepository extends CrudRepository<Status, Integer> {

}
