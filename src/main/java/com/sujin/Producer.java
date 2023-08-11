package com.sujin;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer {

	private final KafkaTemplate<String, String> kafkaTemplate;
	
	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void produceMessage(String topic, String payload) {
		kafkaTemplate.send(topic, payload);
	}
}
