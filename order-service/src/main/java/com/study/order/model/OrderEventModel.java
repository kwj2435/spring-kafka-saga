package com.study.order.model;

import com.study.order.model.OrderModel.OrderItem;
import java.util.List;
import lombok.Getter;

public class OrderEventModel {

  @Getter
  public static class OrderCreatedEvent {

    private final long userId;

    private final long orderId;

    private final List<OrderItem>  orderItemList;

    public OrderCreatedEvent(long userId, long orderId, List<OrderItem> orderItemList) {
      this.userId = userId;
      this.orderId = orderId;
      this.orderItemList = orderItemList;
    }
  }
}
