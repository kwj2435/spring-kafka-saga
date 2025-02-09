package com.study.order.mapper;

import com.study.order.entity.OrderEntity;
import com.study.order.entity.OrderItemEntity;
import com.study.order.model.OrderModel.OrderItem;
import com.study.order.model.OrderModel.OrderResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

// MapStruct 라이브러리 통해 대체 가능
@Component
public class OrderMapper {

  public List<OrderItemEntity> toOrderItemEntityList(
      OrderEntity orderEntity,
      List<OrderItem> orderItemList
  ) {
    List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
    orderItemList.forEach(orderItem ->
        orderItemEntityList.add(toOrderItemEntity(orderEntity, orderItem))
    );

    return orderItemEntityList;
  }

  public OrderItemEntity toOrderItemEntity(OrderEntity orderEntity, OrderItem orderItem) {
    if(orderItem == null){
      throw new IllegalArgumentException("Order Item can not be null");
    }

    return OrderItemEntity.createOrderItem(orderEntity, orderItem);
  }

  public List<OrderItem> toOrderItemList(List<OrderItemEntity> orderItemEntityList) {
    if(orderItemEntityList == null || orderItemEntityList.isEmpty()) {
      throw new IllegalArgumentException("Order item entities cannot be null or empty");
    }

    List<OrderItem> orderItemList = new ArrayList<>();
    orderItemEntityList.forEach(it -> orderItemList.add(toOrderItem(it)));

    return orderItemList;
  }

  public OrderItem toOrderItem(OrderItemEntity orderItemEntity) {
    if (orderItemEntity == null) {
      throw new IllegalArgumentException("Order item entity cannot be null");
    }

    return new OrderItem(orderItemEntity.getProductId(), orderItemEntity.getQuantity());
  }

  public OrderResponse toOrderResponse(OrderEntity orderEntity) {
    if (orderEntity == null) {
      throw new IllegalArgumentException("Order entity cannot be null");
    }

    return new OrderResponse(
        orderEntity.getUserId(),
        orderEntity.getOrderId(),
        orderEntity.getStatus()
    );
  }
}
