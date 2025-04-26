package com.grepp.spring.app.model.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ASHOrderDto {

    private Long orderId;
    private String userId;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryAt;
    private Integer totalPrice;
    private Boolean activated;

    private List<OrderItemDto> items;
}
