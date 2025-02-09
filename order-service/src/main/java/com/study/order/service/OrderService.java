package com.study.order.service;

import com.study.order.entity.OrderEntity;
import com.study.order.entity.OrderItemEntity;
import com.study.order.mapper.OrderMapper;
import com.study.order.model.OrderEventModel.OrderCreatedEvent;
import com.study.order.model.OrderModel.OrderItem;
import com.study.order.model.OrderModel.OrderRequest;
import com.study.order.model.OrderModel.OrderResponse;
import com.study.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
  private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  public OrderResponse createOrder(OrderRequest order) {
    OrderEntity orderEntity = new OrderEntity(order.getUserId());
    List<OrderItemEntity> orderItemEntityList =
        orderMapper.toOrderItemEntityList(orderEntity, order.getOrderItems());
    orderEntity.addOrderItemList(orderItemEntityList);

    OrderEntity savedOrderEntity = orderRepository.save(orderEntity);

    List<OrderItem> orderItemList = orderMapper.toOrderItemList(orderItemEntityList);
    OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent(
        order.getUserId(),
        savedOrderEntity.getOrderId(),
        orderItemList
    );
    kafkaTemplate.send("order_created", orderCreatedEvent);

    return orderMapper.toOrderResponse(savedOrderEntity);
  }
}
