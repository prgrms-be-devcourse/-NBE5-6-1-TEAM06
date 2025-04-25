package com.grepp.spring.app.controller.web.member.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SigninRequest {

    @NotBlank
    private String userId;

    @NotBlank
    @Size(min = 4, max = 10)
    private String password;

}
