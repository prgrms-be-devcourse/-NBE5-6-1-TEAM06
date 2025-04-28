package com.grepp.spring.app.controller.web.member.form;

import com.grepp.spring.app.model.member.dto.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank
    @Email
    private String userId;
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    @NotBlank
    private String userName;
    @NotBlank
    @Size(min = 8, max = 14)
    private String tel;

    public Member toDto(){
        Member member = new Member();
        member.setUserId(userId);
        member.setPassword(password);
        member.setUserName(userName);
        member.setTel(tel);
        return member;
    }

}
