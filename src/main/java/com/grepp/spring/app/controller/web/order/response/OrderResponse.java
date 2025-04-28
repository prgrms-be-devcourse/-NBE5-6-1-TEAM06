package com.grepp.spring.app.controller.web.order.response;

import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.model.order.dto.OrderDetailsDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 결제처리 이후 화면에 보여줄 데이터 반환용도
@Getter
@Setter
@ToString
public class OrderResponse {

    // memberDto
    private String userId; // member table 의 email
    private String userName;

    // orderDto
    private Long orderId;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;
    private String message;
    private String address;
    private String postNumber;
    private String tel;

    // orderDetailsDto
    private Long orderDetailsId;
    private Integer quantity;
    private Integer productPrice;       // 단가
    private Integer unitPrice;          // 상품 합계
    private BigDecimal totalPrice;      // 결제 금액

    // productDto
    private String category;
    private String productName;
    private String productCode;


    private List<OrderDetailsDto> items;
    private OrderStatus orderStatus;

    public String getOrderedAtStr() {
        if (orderedAt == null) {
            return "";
        }
        return orderedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd (E) HH시 mm분 ss초"));
    }

    private String expectedDeliveryDateStr;
    private String orderedAtStr;


}
