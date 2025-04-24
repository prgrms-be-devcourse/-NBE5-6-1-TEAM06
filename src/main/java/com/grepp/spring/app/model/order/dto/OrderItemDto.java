package com.grepp.spring.app.model.order.dto;

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
    private Integer orderPrices;
    private List<Long> productIds;
    private Map<Long, Integer> orderQuantities;
}
