package com.grepp.spring.app.model.auth.domain;

import com.grepp.spring.app.model.member.dto.Member;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class Principal extends User {

    public Principal(String userId, String password,
        Collection<? extends GrantedAuthority> authorities) {
        super(userId, password, authorities);
    }

    public static Principal createPrincipal(Member member,
        List<SimpleGrantedAuthority> authorities) {
        return new Principal(member.getUserId(), member.getPassword(), authorities);
    }
}
