package com.grepp.spring.app.model.order.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private Long orderId;
    private Long productId;
    private Integer orderCnt;
    private Integer productPrice;       // 단가

    // orderComplete.jsp 에서 보여지는 항목
    private String category;
    private String productName;
    private Integer quantity;
    private Integer unitPrice;          // 상품 합계
    private BigDecimal totalPrice;      // 결제 금액
    private LocalDateTime orderedAt;
    private LocalDateTime expectedDeliveryDate;


    private List<Long> productIds;
    private Map<Long, Integer> orderQuantities;

    // 고객에게 보여지진 않지만 확장고려시 필요한 항목
    private String productCode;



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