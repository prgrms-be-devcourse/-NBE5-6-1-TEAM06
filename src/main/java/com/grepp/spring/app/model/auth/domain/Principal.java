package com.grepp.spring.app.model.auth.domain;

<<<<<<< HEAD
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
=======
import com.grepp.spring.app.model.member.dto.Member;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
>>>>>>> origin/kdy
import org.springframework.security.core.userdetails.User;

public class Principal extends User {
    
    public Principal(String username, String password,
        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
<<<<<<< HEAD
=======
    
    public static Principal createPrincipal(Member member,
        List<SimpleGrantedAuthority> authorities){
        return new Principal(member.getUserId(), member.getPassword(), authorities);
    }
>>>>>>> origin/kdy
}
