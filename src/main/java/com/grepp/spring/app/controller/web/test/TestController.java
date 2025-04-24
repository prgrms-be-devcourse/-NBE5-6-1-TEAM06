package com.grepp.spring.app.controller.web.test;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    // 각각의 아이디에 대해서 정상적으로 출력 확인

    // 테스트용 로그인 메서드
    // 데이터베이스에 없는 사용자 -> 데이터 아무것도 출력 안됨
    @GetMapping("testLoginerror")
    public String testLogin(HttpSession session) {
        session.setAttribute("user_id", "hi@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }

    // 테스트용 로그인 메서드
    // 도윤님 장바구니
    @GetMapping("testLoginkdu")
    public String testLoginKDU(HttpSession session) {
        session.setAttribute("user_id", "kdu@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }

    // 테스트용 로그인 메서드
    // 세희님 장바구니
    @GetMapping("testLoginash")
    public String testLoginASH(HttpSession session) {
        session.setAttribute("user_id", "ash@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }

    // 테스트용 로그인 메서드
    // 강현 장바구니
    @GetMapping("testLoginlkh")
    public String testLoginLKH(HttpSession session) {
        session.setAttribute("user_id", "lkh@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }

    // 테스트용 로그인 메서드
    // 초롱님 장바구니
    @GetMapping("testLoginlcr")
    public String testLoginLCR(HttpSession session) {
        session.setAttribute("user_id", "lcr@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }

    // 테스트용 로그인 메서드
    // 영준님 장바구니
    @GetMapping("testLoginhyj")
    public String testLoginHYJ(HttpSession session) {
        session.setAttribute("user_id", "hyj@example.com");  // 임시로 user_id 저장
        return "redirect:member/cartList";  // 장바구니 페이지로 이동
    }
}
