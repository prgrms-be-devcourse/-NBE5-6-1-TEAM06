package com.grepp.spring.app.model.cart.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Cart")
public class Cart {
    private int cartId;
    private String userId;
    private int productId;
    private int productCnt;
}
