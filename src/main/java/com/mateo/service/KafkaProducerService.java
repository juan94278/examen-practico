package com.mateo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Description: Class that implements the interface IKafkaProducerService
 * @author Juan Mateo
 *
 */
@Slf4j
@Service
public class KafkaProducerService implements IKafkaProducerService {
	
	/**
	 * Topic name
	 */
	private static final String TOPIC = "payment_topic";
	
	/**
	 * KafkaTemplate which brings the connection to kafka
	 */
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	/**
	 * Method that sends messages using a Kafka topic
	 * @param message to send
	 */
	@Override
	public void sendMessage(String message) {
		kafkaTemplate.send(TOPIC, message);
		log.info("Message sent: " + message);
	}

}
