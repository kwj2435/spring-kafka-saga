package com.study.order.entity;

import com.study.order.model.OrderModel.OrderItem;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORDER_ITEM_ID")
  private Long orderItemId;  // 주문 항목 ID

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ORDER_ID", nullable = false)
  private OrderEntity orderEntity;

  @Column(name = "PRODUCT_ID", nullable = false)
  private long productId;

  @Column(nullable = false)
  private int quantity;  // 주문 수량

  @Column(nullable = false)
  private int price;

  @Column(name = "TOTAL_PRICE", nullable = false)
  private int totalPrice;

  @Column(name = "CREATED_AT", updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now();  // 생성 일시

  @Column(name = "UPDATED_AT")
  private LocalDateTime updatedAt = LocalDateTime.now();  // 수정 일시

  public static OrderItemEntity createOrderItem(OrderEntity orderEntity, OrderItem orderItem) {
    int price = 1000; // 본래 상품 모듈에서 조회해야하나, 상품 모듈이 없으므로 1000원으로 고정

    return OrderItemEntity.builder()
        .orderEntity(orderEntity)  // orderEntity
        .productId(orderItem.getProductId())
        .price(price)  // 상품 모듈이 없으므로 1000원으로 고정
        .quantity(orderItem.getQuantity())
        .totalPrice(price * orderItem.getQuantity())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();
  }

  public void addOrderEntity(OrderEntity orderEntity) {
    this.orderEntity = orderEntity;
  }
}
