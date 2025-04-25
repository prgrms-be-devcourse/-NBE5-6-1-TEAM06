package com.grepp.spring.app.model.order.dto;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OrderDto {

    private Long orderId;
    private String userId;
    private LocalDateTime orderDate; //order_date
    private LocalDateTime expectDeliveryDate;
    private String address;
    private String postNumber;
    private int totalPrice;
    private int orderItems;
    private Boolean activated;

    // DB에 없는 것
    private List<OrderItemDto> items;

}