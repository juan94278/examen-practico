package com.mateo.exception;

/**
 * Description: Class to generate a custom exception
 * @author Juan Mateo
 *
 */
public class DataException extends Exception {

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 2894905589196628248L;
	
	/**
	 * Constructor method with description parameter
	 * @param description which is sent to the exception
	 */
	public DataException(String description) {
		super(description);
	}
	
	/**
	 * Constructor method with description and exception parameter
	 * @param description which is sent to the exception
	 * @param t exception that was caused
	 */
	public DataException(String description, Throwable t) {
		super(description, t);
	}

}
