package com.grepp.spring.app.controller.web.order.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class OrderRequest {

    @NotBlank
    private String userId;
    @NotBlank
    private String userName;


    @NotBlank
    @Size(min = 10, max =30)
    private String tel;

    @NotBlank
    @Size(min = 10, max =150)
    private String address; // main 통합 후 principal 에서 get.userAddress 해도 될것같음

    @NotBlank
    @Size(min = 4, max =5)
    private String postNumber;

    private boolean fromCart; // 장바구니 기반 주문 여부
    private List<Long> productIds;
    private List<Integer> quantities;
}
