package com.grepp.spring.app.model.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MockOrderItemDto {

    private String orderId;
    private long orderDetailsId;
    private Integer productPrice; // 주문 시점의 prod price
    private String productName;  //join 결과 담기(productId도 갖고오면 좋을 듯)
    private Integer orderCnt;
}