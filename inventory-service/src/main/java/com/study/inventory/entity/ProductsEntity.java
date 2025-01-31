package com.study.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId; // 상품 ID

  @Column(nullable = false, length = 255)
  private String name; // 상품명

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal price; // 상품 가격

  @Column(nullable = false)
  private int availableStock; // 사용 가능한 재고 수량

  @Column(updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  private LocalDateTime createdAt; // 상품 등록일

  @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
  private LocalDateTime updatedAt; // 상품 업데이트일

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
