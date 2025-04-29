package com.grepp.spring.app.model.product.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private int stock;
    private int quantity;
    private String info;
    private String productImgUrl;
    private String productName = "상품명없음";  // 기본값
    private BigDecimal price = BigDecimal.ZERO;
    private String category = "기타";
    private String code = "없음";
}