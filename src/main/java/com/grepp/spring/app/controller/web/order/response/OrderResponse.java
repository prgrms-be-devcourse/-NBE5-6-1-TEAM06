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

    private Long orderId;
    private String userId; // member table 의 email
    private String userName;
    private String message;
    private BigDecimal totalPrice;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;

    private List<OrderDetailsDto> items;
    private OrderStatus orderStatus;

    public String getOrderedAtStr() {
        if (orderedAt == null) return "";
        return orderedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd (E) HH시 mm분 ss초"));
    }

    private String expectedDeliveryDateStr;
}
