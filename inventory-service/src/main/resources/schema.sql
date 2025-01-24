CREATE TABLE products (
                          product_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 상품 ID
                          name VARCHAR(255) NOT NULL,                   -- 상품명
                          price DECIMAL(10, 2) NOT NULL,                -- 상품 가격
                          available_stock INT NOT NULL,                 -- 사용 가능한 재고 수량
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 상품 등록일
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 상품 업데이트일
);