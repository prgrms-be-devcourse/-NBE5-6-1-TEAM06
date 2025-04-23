package com.grepp.spring.app.model.member.dto;

import com.grepp.spring.app.model.auth.code.Role;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.type.Alias;

@Alias("MEMBER_PRINCIPAL")
public record Principal(
    String userId,
    List<Role> Roles,
    LocalDateTime loginedAt
) {
    
    public static final Principal ANONYMOUS = new Principal(
        "anonymous",
        List.of(Role.ANONYMOUS),
        LocalDateTime.now());
}
