package com.grepp.spring.app.model.product.dto;

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
    private String category;
    private String productName;
    private int price;
    private int stock;
    private String code;
    private String info;
    private String productImgUrl;
}