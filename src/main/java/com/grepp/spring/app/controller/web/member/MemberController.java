package com.grepp.spring.app.controller.web.member;

import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.member.dto.MemberDto;
import com.grepp.spring.app.model.order.OrderDto;
import com.grepp.spring.app.model.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("mypage")
    public String mypage(Authentication authentication, Model model){
        log.info("authentication : {}", authentication);
        // note ash 화면 테스트용 하드코딩된 userId
        String userId = "testUser";
        // authentication.getName();

        MemberDto memberDto = memberService.findById(userId);
        model.addAttribute("memberDto", memberDto);

        List<OrderDto> orderList = orderService.getOrdersByUserId(userId);
        model.addAttribute("orderList", orderList);

        return "member/mypage";
    }

}
