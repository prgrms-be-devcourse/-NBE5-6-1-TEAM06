package com.grepp.spring.app.model.order.dto;

import java.util.List;
import java.util.Map;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {

    private Long orderDetailsId;
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