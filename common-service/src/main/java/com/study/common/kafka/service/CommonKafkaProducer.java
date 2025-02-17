package com.study.common.kafka.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonKafkaProducer {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String topic, String message) {
    try {
      kafkaTemplate.send(topic, message);
      System.out.println("Sent message:" + message);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
