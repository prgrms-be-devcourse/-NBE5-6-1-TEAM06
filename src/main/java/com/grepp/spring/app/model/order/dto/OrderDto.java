package com.grepp.spring.app.model.order.dto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDto {

    private Long orderId;
    private String userId;
    private LocalDateTime orderedAt; //order_date
    private LocalDateTime expectDeliveriedAt;
    private String address;
    private String postNumber;
    private int totalPrice;
    private int orderItems;
    private Boolean activated;
    
    // DB에 없는 것
    private List<OrderItemDto> items;

}
