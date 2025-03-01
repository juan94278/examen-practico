package com.mateo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mateo.model.ResponseGeneric;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: Class to resolve different types of exception
 * @author Juan Mateo
 *
 */
@Slf4j
@ControllerAdvice
public class GlobalException {
	
	/**
	 * ExceptionHandler that intercepts the error caused by DataException
	 * @param ex data exception
	 * @return <ResponseEntity>
	 */
	@ExceptionHandler(value = { DataException.class })
	public ResponseEntity<ResponseGeneric> errorHandler(DataException ex) {
		log.error("Caching data error...");
		ResponseGeneric response = new ResponseGeneric();
		response.setError(ex.getMessage());
		return new ResponseEntity<ResponseGeneric>(response, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * ExceptionHandler that intercepts the error caused by NumberFormatException
	 * @param ex format exception
	 * @return <ResponseEntity>
	 */
	@ExceptionHandler(value = { NumberFormatException.class })
	public ResponseEntity<ResponseGeneric> errorHandler(NumberFormatException ex) {
		log.error("Caching format error...");
		ResponseGeneric response = new ResponseGeneric();
		response.setError(ex.getMessage());
		return new ResponseEntity<ResponseGeneric>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * ExceptionHandler that intercepts the error caused by Exception
	 * @param ex generic exception
	 * @return <ResponseEntity>
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<ResponseGeneric> errorHandler(Exception ex) {
		log.error("catching generic error...");
		ResponseGeneric response = new ResponseGeneric();
		response.setError(ex.getMessage());
		return new ResponseEntity<ResponseGeneric>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
