package com.grepp.spring.app.controller.web.member.form;

<<<<<<< HEAD
=======
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
>>>>>>> origin/kdy
import lombok.Data;

@Data
public class SigninRequest {

<<<<<<< HEAD
=======
    @NotBlank
    private String userId;

    @NotBlank
    @Size(min = 4, max = 10)
    private String password;

>>>>>>> origin/kdy
}
