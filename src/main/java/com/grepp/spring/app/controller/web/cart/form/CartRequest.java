package com.grepp.spring.app.controller.web.cart.form;

import lombok.Data;

@Data
public class CartRequest {
    private int productCnt;
    private long cartDetailsId;
}
