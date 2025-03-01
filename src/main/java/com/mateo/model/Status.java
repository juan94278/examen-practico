package com.mateo.model;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Description: Clase entidad estatus
 * @author Juan Mateo
 *
 */
@Getter
@Setter
@Entity(name = "status_payment")
public class Status implements Serializable {
	
	/**
	 * Status ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "status_id")
	@NotNull(message = "The statusId is required")
	@Schema(name = "statusId", example = "1")
	private Integer statusId;
	
	/**
	 * Description
	 */
	@Schema(name = "description", example = "Iniciado")
	private String description;

	/**
	 * @Serial
	 */
	private static final long serialVersionUID = 4366700209512610241L;

}
