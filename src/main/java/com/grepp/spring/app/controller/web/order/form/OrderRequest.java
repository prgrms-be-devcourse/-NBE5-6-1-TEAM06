package com.grepp.spring.app.controller.web.order.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderRequest {

    @NotBlank
    private String userId;

    @NotBlank
    @Size(min = 10, max =30)
    private String userEmail;

    @NotBlank
    private String userAddress; // principal 에서 get.userAddress 해도 될것같음
}
