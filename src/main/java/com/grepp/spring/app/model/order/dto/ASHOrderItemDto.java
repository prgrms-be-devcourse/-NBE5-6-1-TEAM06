package com.grepp.spring.app.model.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ASHOrderItemDto {

    private Long orderDetailsId;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer orderCnt;
    private Integer productPrice;

}
