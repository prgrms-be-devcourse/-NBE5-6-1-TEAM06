package com.grepp.spring.app.controller.web.member;

import com.grepp.spring.app.controller.web.member.form.CartRequest;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.OrderDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    //TODO : 장바구니 조회, 장바구니 수정, 장바구니 삭제

    private final MemberService memberService;
    private final CartService cartService;
    private final OrderService orderService;


    // 도윤님 로그인 기능 구현 시  @AuthenticationPrincipal 통해서 사용자 정보 불러도록
//    @GetMapping("cartList")
//    public String CartList(Model model, @AuthenticationPrincipal User user) {
//        String email = user.getUsername();
//        List<CartProduct> cartList = cartService.getCartListByUserId(email);
//
//        model.addAttribute("cartList", cartList);
//        return "member/cartList";
//    }

    // 임시 HTTP 세션을 이용
    // TEST Controller 이용
    @GetMapping("/cartList")
    public String cartList(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("user_id");  // 세션에서 user_id 가져오기
        if (userId == null) {
            return "redirect:/login";  // 로그인 안 되어 있으면 로그인 페이지로 리다이렉트
        }

        List<CartProduct> cartList = cartService.getCartListByUserId(userId);
        model.addAttribute("cartList", cartList);
        return "member/cartList";
    }

    @PostMapping("cartList")
    public String modifyCart(@ModelAttribute CartRequest cartRequest) {

        return "order";
    }

    @DeleteMapping("cartList")
    public String deleteCartList(@ModelAttribute CartRequest cartRequest) {
        return "redirect:/member/cartList";
    }


    @GetMapping("mypage")
    public String mypage(Authentication authentication, Model model){
        log.info("authentication : {}", authentication);
        // 화면 테스트용 하드코딩된 userId
        String userId = "ash@example.com";
        // authentication.getName();

        Member member = memberService.findById(userId);
        model.addAttribute("member", member);

        List<OrderDto> orderList = orderService.getOrdersByUserId(userId);
        model.addAttribute("orderList", orderList);

        return "member/mypage";
    }

}
