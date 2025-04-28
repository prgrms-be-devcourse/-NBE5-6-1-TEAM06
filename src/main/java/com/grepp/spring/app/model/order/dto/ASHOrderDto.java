package com.grepp.spring.app.model.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class ASHOrderDto {

    private Long orderId;
    private String userId;
    private String userName;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;
    private Integer totalPrice;
    private Boolean activated;

    private List<OrderItemDto> items;

    // 컨트롤러에서 포맷팅까지 하니까 컨트롤러가 너무 무거워지는 것 같아서,
    // dto에 추가부터 하는 방식 선택 손은 많이 가지만 포맷팅된 값을 따로 관리할 수 있어서 좋은 것 같음
    private String formattedOrderedAt;
    private String formattedExpectedDeliveryDate;
}
