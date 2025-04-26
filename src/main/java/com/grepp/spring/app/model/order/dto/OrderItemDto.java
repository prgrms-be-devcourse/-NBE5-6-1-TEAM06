package com.grepp.spring.app.model.order.dto;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class OrderItemDto {

    private Long oderDetailsId;
    private String orderId;
    private long productId;
    private Integer orderCnt;
    private Integer productPrice;

    // DB에 없는 것
    private String productName;
    private Integer totalPrice;  //unitPrice
    private Map<Long, Integer> orderQuantities;
    private String productCode;
    private String category;
    private Integer quantity;
    private List<Long> productIds;
}