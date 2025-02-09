package com.study.order.controller;

import com.study.order.model.OrderModel.OrderRequest;
import com.study.order.model.OrderModel.OrderResponse;
import com.study.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @PostMapping
  public OrderResponse postOrder(@RequestBody OrderRequest order) {
      return orderService.createOrder(order);
  }
}
