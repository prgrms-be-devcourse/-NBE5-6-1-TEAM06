package com.grepp.spring.app.controller.web.order.form;

import com.grepp.spring.app.controller.web.order.code.OrderStatus;
import com.grepp.spring.app.model.order.dto.OrderDetailsDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequest {

    @NotBlank
    private String userId;
    @NotBlank
    private String userName;


    @NotBlank
    @Size(min = 10, max = 30)
    private String tel;

    @NotBlank
    @Size(min = 10, max = 150)
    private String address;

    @NotBlank
    @Size(min = 4, max = 5)
    private String postNumber;

    private boolean fromCart; // 장바구니 기반 주문 여부
    private Long orderId;
    private List<OrderDetailsDto> orderDetails;
    private List<Long> productIds;
    private List<Integer> quantities;
    private BigDecimal totalPrice;
    private OrderStatus orderStatus;
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;
    private boolean activated;
    private List<OrderDetailsDto> items = new ArrayList<>();

    public String getExpectedDeliveryDateStr() {
        if (this.expectedDeliveryDate == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)", Locale.KOREA);
        return this.expectedDeliveryDate.format(formatter);
    }


    public String getOrderedAtStr() {
        if (this.orderedAt == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (E)");
        return this.orderedAt.format(formatter);
    }
}
