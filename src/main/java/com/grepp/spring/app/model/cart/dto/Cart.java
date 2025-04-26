package com.grepp.spring.app.model.cart.dto;

import java.util.List;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Cart")
public class Cart {
    private Long cartId;
    private String userId;
    private List<CartProduct> products;
}
