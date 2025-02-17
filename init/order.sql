USE ORDER;
CREATE TABLE ORDERS (
    ORDER_ID BIGINT AUTO_INCREMENT PRIMARY KEY, -- 주문 ID
    USER_ID BIGINT NOT NULL,                   -- 사용자 ID
    STATUS VARCHAR(20) NOT NULL,               -- 주문 상태 (E.G., CREATED, CONFIRMED, CANCELLED)
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 주문 생성일
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 주문 업데이트일
);

CREATE TABLE ORDER_ITEMS (
     ORDER_ITEM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 주문 항목 ID (고유)
     ORDER_ID BIGINT NOT NULL,                         -- 주문 ID (외래 키)
     PRODUCT_ID BIGINT NOT NULL,                       -- 상품 ID
     QUANTITY INT NOT NULL,                            -- 주문 수량
     PRICE INT NOT NULL,                                -- 상품 단가
     TOTAL_PRICE INT NOT NULL,                          -- 총 가격 (QUANTITY * PRICE)
     CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,   -- 주문 항목 생성 일시
     UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  -- 주문 항목 수정 일시
);