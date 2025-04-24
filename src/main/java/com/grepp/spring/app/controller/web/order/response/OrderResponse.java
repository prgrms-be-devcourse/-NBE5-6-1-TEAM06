package com.grepp.spring.app.controller.web.order.response;

import java.time.LocalDateTime;

// 결제처리 이후 화면에 보여줄 데이터 반환용도
public class OrderResponse {
    private Long orderId;
    private String message;
    private int totalPrice;
    private LocalDateTime orderedAt;
}
