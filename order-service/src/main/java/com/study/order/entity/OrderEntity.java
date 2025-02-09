package com.study.order.entity;

import com.study.order.enums.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

  // 주문 ID
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  // 사용자 ID
  @Column(nullable = false)
  private long userId;

  // 주문 상태
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private OrderStatus status;

  // 주문 생성일
  @Column(updatable = false)
  private LocalDateTime createdAt;

  // 주문 업데이트일
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderItemEntity> orderItemEntityList;

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }

  public OrderEntity(long userId) {
    this.userId = userId;
    this.orderItemEntityList = null;
    this.status = OrderStatus.PENDING;
  }

  public void addOrderItemList(List<OrderItemEntity> orderItemEntityList) {
    if(this.orderItemEntityList == null || orderItemEntityList.isEmpty()) {
      throw new IllegalArgumentException("orderItemEntityList is null or empty");
    }

    this.orderItemEntityList = orderItemEntityList;
    orderItemEntityList.forEach(orderItemEntity -> {
      orderItemEntity.addOrderEntity(this);
    });
  }
}
