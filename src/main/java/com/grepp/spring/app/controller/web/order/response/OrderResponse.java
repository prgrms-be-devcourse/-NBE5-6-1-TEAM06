package com.grepp.spring.app.controller.web.order.response;

import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.model.order.dto.OrderItemDto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

// 결제처리 이후 화면에 보여줄 데이터 반환용도
@Getter
@Builder
public class OrderResponse {
    private Long orderId;
    private String userId; // member table 의 email
    private String message;
    private int totalPrice;
    private LocalDateTime orderDate;
    private LocalDateTime expectDeliveryDate;

    private List<OrderItemDto> items;
    private OrderStatus orderStatus;

}
