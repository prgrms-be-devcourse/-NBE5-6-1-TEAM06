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

    private Long orderId;
    private Long oderItemId;
    private Integer orderPrices;    //ash 주문 시점의 prod price
    private Integer productIds;     //ash product 조인 결과 받는 값
    private String productName;     //ash product 조인 결과 받는 값
    private Integer orderCnt;
}
