package com.study.order.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
  CREATED("주문 생성"),
  PENDING("처리 중"),
  CONFIRMED("주문 확정됨"),
  COMPLETED("주문 완료됨"),
  CANCELLED("주문 취소됨"),
  FAILED("주문 실패");

  private final String description;  // 상태 설명
}
