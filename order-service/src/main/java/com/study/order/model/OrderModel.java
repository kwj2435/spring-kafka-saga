package com.study.order.model;

import com.study.order.enums.OrderStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class OrderModel {

  @Getter
  @NoArgsConstructor
  public static class OrderRequest {

    // 유저 ID
    private long userId;

    // 주문 상품 리스트
    private List<OrderItem> orderItems;
  }

  @Getter
  @AllArgsConstructor
  public static class OrderItem {

    // 상품 ID
    private long productId;

    // 상품 수량
    private int quantity;
  }

  @Getter
  @AllArgsConstructor
  public static class OrderResponse {

    // 유저 ID
    private long userId;

    // 주문 ID
    private long orderId;

    // 주문 상태
    private OrderStatus orderStatus;
  }
}
