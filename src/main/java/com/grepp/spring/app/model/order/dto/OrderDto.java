package com.grepp.spring.app.model.order.dto;
import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@ToString
public class OrderDto {

    private Long orderId;
    private String userId;
    private String userName;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;
    private String address;
    private String postNumber;
//    private int orderItems;
    private Boolean activated;
    private OrderStatus orderStatus;
    private String category = "기타";    // 기본값 세팅!
    private String productName = "상품명없음"; // 기본값 세팅!
    private Integer quantity = 0;
    private Integer unitPrice = 0;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private String productCode = "없음";   // 기본값 세팅!

    // DB에 없는 것
    private List<OrderDetailsDto> items;
    private List<OrderDetailsDto> orderDetailsDto;


}