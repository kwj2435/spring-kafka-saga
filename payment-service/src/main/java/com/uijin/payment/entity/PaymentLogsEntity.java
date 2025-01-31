package com.uijin.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentLogsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "log_id")
  private Long logId; // 로그 ID

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_id", nullable = false)
  private PaymentsEntity payment; // 결제 ID

  @Column(name = "message", nullable = false, columnDefinition = "TEXT")
  private String message; // 로그 메시지 (e.g., 결제 성공/실패 이유)

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt; // 로그 생성일

  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }
}
