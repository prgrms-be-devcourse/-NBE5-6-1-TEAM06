package com.grepp.spring.app.controller.web.cart.form;

import lombok.Data;

@Data
public class CartDetailsRequest {
    private Long orderId;
    private Long cartDetailsId;
    private int productCnt;
}
