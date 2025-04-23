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
public class OrderItemDto {
    private String orderId;
    private long oderDetailsId;
    private Integer productPrices; //orderDto totalPrice 와 뭐가다른거지?
    private List<Long> productIds;
    private Map<Long, Integer> productIdToQuantity;
}
