package com.grepp.spring.app.model.order.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {
    private Integer orderId;
    private String userId;
    private String address;
    private Integer postNumber;
    private Integer totalPrice;
    private LocalDateTime orderedAt; //order_date
    private LocalDateTime expectDeliveryAt;
    private List<OrderItemDto> orderItems;
    private Boolean activated;
}
