package com.grepp.spring.app.model.order.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailsDto {

    private Long orderDetailsId;
    private String orderId;
    private long productId;
    private Integer orderCnt;
    private Integer productPrice; // 단가

    // DB에 없는 것
    private Integer unitPrice;      // 상품 합계
    private Integer totalPrice;      // 결제 금액
    private String category;
    private List<Long> productIds;
    private String productName;
    private String productCode;
    private Integer quantity;
    private Map<Long, Integer> orderQuantities;

    // 총액 계산
    public BigDecimal getTotalPrice() {
        if (unitPrice == null || quantity == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(unitPrice)
            .multiply(BigDecimal.valueOf(quantity));
    }

    // 팩토리 메서드
    public static OrderDetailsDto of(
        String productCode,
        String category,
        String productName,
        int productPrice,
        int quantity) {

        OrderDetailsDto dto = new OrderDetailsDto();
        dto.setProductCode(productCode);
        dto.setCategory(category);
        dto.setProductName(productName);
        dto.setProductPrice(productPrice);
        dto.setUnitPrice(productPrice);
        dto.setQuantity(quantity);
        return dto;
    }
}