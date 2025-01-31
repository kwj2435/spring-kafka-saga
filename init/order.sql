CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 주문 ID
    user_id BIGINT NOT NULL,                   -- 사용자 ID
    status VARCHAR(20) NOT NULL,               -- 주문 상태 (e.g., CREATED, CONFIRMED, CANCELLED)
    total_price DECIMAL(10, 2) NOT NULL,       -- 총 주문 금액
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 주문 생성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 주문 업데이트일
);