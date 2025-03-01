package com.mateo.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@ExtendWith(MockitoExtension.class)
public class KafkaProducerConfigTest {
	
	@InjectMocks
	private KafkaProducerConfig kafkaProducerConfig;
	
	@Test
	public void testProducerFactory() {
		ProducerFactory<String, String> producer = kafkaProducerConfig.producerFactory();
		assertNotNull(producer);
	}
	
	@Test
	public void testKafkaTemplate() {
		KafkaTemplate<String, String> kafkaTemplate = kafkaProducerConfig.kafkaTemplate();
		assertNotNull(kafkaTemplate);
	}
	

}
