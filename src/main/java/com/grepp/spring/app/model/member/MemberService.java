package com.grepp.spring.app.model.member;

import com.grepp.spring.app.model.member.dto.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService{

    public Member findById(String userId) {
        Member mock = new Member();
        mock.setUserId(userId);
        return mock;
//        return memberRepository.selectById(userId)
//                .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));
    }
}
