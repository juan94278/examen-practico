package com.mateo.service;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@ExtendWith(MockitoExtension.class)
public class KafkaProducerServiceTest {
	
	@InjectMocks
	private KafkaProducerService kafkaProducerService;
	
	@Mock
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	public void testSendMessage() {
		CompletableFuture<SendResult<String, String>> sad = new CompletableFuture<>();
		when(kafkaTemplate.send(anyString(), anyString())).thenReturn(sad);
		kafkaProducerService.sendMessage("Message");
	}

}
