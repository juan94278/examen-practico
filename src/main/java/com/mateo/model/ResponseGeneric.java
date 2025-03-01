package com.mateo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: Class for generic response
 * @author Juan Mateo
 *
 */
@Getter
@Setter
public class ResponseGeneric implements Serializable{

	/**
	 * @serial
	 */
	private static final long serialVersionUID = 8257577989396085202L;
	
	/**
	 * Data
	 */
	@Schema(name = "data", example = "SUCCESS")
	private Object data;
	
	/**
	 * Error
	 */
	@Schema(name = "error", example = "Payment not found.")
	private String error;

}
