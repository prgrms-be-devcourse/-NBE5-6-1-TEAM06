package com.grepp.spring.app.model.member;

import com.grepp.spring.app.model.auth.code.Role;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.member.dto.MemberInfo;
import com.grepp.spring.infra.error.exceptions.CommonException;
import com.grepp.spring.infra.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    
    @Transactional
    public void signup(Member dto, Role role) {
        if(memberRepository.existsMember(dto.getUserId()))
            throw new CommonException(ResponseCode.BAD_REQUEST);
        
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        dto.setPassword(encodedPassword);
        
        dto.setRole(role);
        memberRepository.insert(dto);
        


    }
    
//    public Principal signin(String userId, String password) {
//
//        Optional<Member> optional = memberRepository.selectById(userId);
//
//        if(optional.isEmpty())
//            return Principal.ANONYMOUS;
//
//        Member member = optional.get();
//
//        if(!member.getPassword().equals(password))
//            return Principal.ANONYMOUS;
//
//        return new Principal(userId, List.of(Role.ROLE_USER), LocalDateTime.now());
//    }
    
    public Boolean isDuplicatedId(String id) {
        return memberRepository.existsMember(id);
    }
    
    public Member findById(String userId) {
        return memberRepository.selectById(userId)
                            .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));
    }
}
