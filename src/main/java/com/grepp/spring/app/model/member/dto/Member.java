package com.grepp.spring.app.model.member.dto;

<<<<<<< HEAD
=======
import com.grepp.spring.app.model.auth.code.Role;
>>>>>>> origin/kdy
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Member")
public class Member {

    private String userId;
<<<<<<< HEAD

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
=======
    private String password;
    private String username;
    private Role role;
    private String tel;
//    private MemberInfo info;
//    private Boolean activated;
>>>>>>> origin/kdy
}
