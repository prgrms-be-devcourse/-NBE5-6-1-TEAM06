package com.grepp.spring.app.controller.web.cart.form;

import lombok.Data;

@Data
public class CartDetailsRequest {
    private int productCnt;
    private Long cartDetailsId;
}
