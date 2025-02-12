package com.study.inventory.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryConsumer {

  @KafkaListener(topics = "order_created")
  public void consumeOrderCreated(String message) {
    System.out.println(message);
  }
}
