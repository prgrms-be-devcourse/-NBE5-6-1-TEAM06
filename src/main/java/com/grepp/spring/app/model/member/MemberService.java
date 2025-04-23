package com.grepp.spring.app.model.member;

import com.grepp.spring.app.model.member.dto.MemberDto;
import com.grepp.spring.infra.error.exceptions.CommonException;
import com.grepp.spring.infra.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService{

    public MemberDto findById(String userId) {
        MemberDto mock = new MemberDto();
        mock.setUserId(userId);
        return mock;
//        return memberRepository.selectById(userId)
//                .orElseThrow(() -> new CommonException(ResponseCode.BAD_REQUEST));
    }
}
