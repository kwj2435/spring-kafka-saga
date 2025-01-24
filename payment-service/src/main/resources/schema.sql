CREATE TABLE payments (
                          payment_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 결제 ID
                          order_id BIGINT NOT NULL,                     -- 주문 ID
                          user_id BIGINT NOT NULL,                      -- 사용자 ID
                          amount DECIMAL(10, 2) NOT NULL,               -- 결제 금액
                          status VARCHAR(20) NOT NULL,                  -- 결제 상태 (e.g., INITIATED, SUCCESS, FAILED)
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 결제 생성일
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 결제 업데이트일
);

CREATE TABLE payment_logs (
                              log_id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 로그 ID
                              payment_id BIGINT NOT NULL,               -- 결제 ID
                              message TEXT NOT NULL,                    -- 로그 메시지 (e.g., 결제 성공/실패 이유)
                              created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 로그 생성일
                              FOREIGN KEY (payment_id) REFERENCES payments(payment_id)
);