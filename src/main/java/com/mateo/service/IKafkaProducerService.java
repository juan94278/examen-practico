package com.mateo.service;

/**
 * Description: Interface that defines the methods for sending messages using Kafka
 * @author Juan Mateo
 *
 */
public interface IKafkaProducerService {
	
	/**
	 * Method that sends messages using a Kafka topic
	 * @param message to send
	 */
	public void sendMessage(String message);

}
