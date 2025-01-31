package com.uijin.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private Long paymentId; // 결제 ID

  @Column(name = "order_id", nullable = false)
  private Long orderId; // 주문 ID

  @Column(name = "user_id", nullable = false)
  private Long userId; // 사용자 ID

  @Column(name = "amount", nullable = false, precision = 10, scale = 2)
  private BigDecimal amount; // 결제 금액

  @Column(name = "status", nullable = false, length = 20)
  private String status; // 결제 상태 (e.g., INITIATED, SUCCESS, FAILED)

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt; // 결제 생성일

  @Column(name = "updated_at")
  private LocalDateTime updatedAt; // 결제 업데이트일

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = LocalDateTime.now();
  }
}
