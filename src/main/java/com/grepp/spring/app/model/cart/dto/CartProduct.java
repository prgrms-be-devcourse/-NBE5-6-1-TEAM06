package com.grepp.spring.app.model.cart.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CartProduct")
public class CartProduct {
    private Long cartDetailsId;
    private Long cartId;
    private Long productId;
    private int productCnt;

    private String userId;

    private String productName;
    private int productPrice;
    private String category;

    // 추가
    private String userName;
    private LocalDate orderedAt = LocalDate.now(); // 주문일시
    private LocalDate expectedDeliveryAt = LocalDate.now().plusDays(1); // 예상 배송일

}
