package com.grepp.spring.app.model.order.dto;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class OrderItemDto {

    private Long orderDetailsId;
    private Long orderId;
    private Long productId;
    private Integer orderCnt;
    private Integer productPrice;

    // DB에 없는 것
    private String productName;
    private Integer totalPrice;                 // ash OrderItemDto에서 totalPrice객체를 왜 만들죠..?
    private Map<Long, Integer> orderQuantities; // ash OrderDetail Table에서의 1개 row가 여기서 객체로 만들어져야 해서.. 여기 Map으로 묶으면 안 될 것 같아요
    private String productCode;
    private String category;
    private Integer quantity;
    private List<Long> productIds;


}
