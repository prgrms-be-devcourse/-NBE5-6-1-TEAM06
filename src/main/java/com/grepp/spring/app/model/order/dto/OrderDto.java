package com.grepp.spring.app.model.order.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class OrderDto {
    private Long orderId;
    private String userName;
    private String productName;
    private int productCnt;
    private int totalPrice;
    private LocalDateTime createdAt;
}
