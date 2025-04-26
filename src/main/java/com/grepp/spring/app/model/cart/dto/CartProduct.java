package com.grepp.spring.app.model.cart.dto;

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

}
