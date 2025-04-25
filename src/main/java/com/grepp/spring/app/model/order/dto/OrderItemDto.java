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

    private Long orderId;
    private Long oderItemId;
    private Integer orderPrices;    //ash 주문 시점의 prod price
    private Long productIds;     //ash product 조인 결과 받는 값
    private String productName;     //ash product 조인 결과 받는 값
    private Integer orderCnt;
    private Long oderDetailsId;

    // DB에 없는 것
//    private Integer totalPrice;   // ash totalPrice를 itemDto에서 다루는 이유를 모르겠습니다!
//    private Map<Long, Integer> orderQuantities;   // ash OrderDetail Table에서의 1개 row가 여기서 객체로 만들어져야 해서.. 여기 Map으로 묶으면 안 될 것 같아요
    private String productCode;
    private String category;
//    private Integer quantity;     // ash orderCnt 인 것 같아요
}
