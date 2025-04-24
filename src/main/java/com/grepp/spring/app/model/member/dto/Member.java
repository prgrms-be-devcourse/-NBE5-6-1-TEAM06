package com.grepp.spring.app.model.member.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Member")
public class Member {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
