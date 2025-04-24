package com.grepp.spring.app.model.cart.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("CartProduct")
public class CartProduct {
    private int cartId;
    private String userId;
    private int productId;
    private int productCnt;

    private String productName;
    private int productPrice;

}
