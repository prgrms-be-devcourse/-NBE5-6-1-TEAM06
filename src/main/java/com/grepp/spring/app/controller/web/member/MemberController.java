package com.grepp.spring.app.controller.web.member;


import com.grepp.spring.app.controller.web.member.form.CartRequest;
import com.grepp.spring.app.controller.web.member.form.SigninRequest;
import com.grepp.spring.app.controller.web.member.form.SignupRequest;
import com.grepp.spring.app.model.auth.code.Role;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.order.ASHOrderService;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import com.grepp.spring.app.model.order.dto.OrderDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final ASHOrderService ashOrderService;

    @GetMapping("signup")
    public String signup(SignupRequest form) {
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(
            @Valid SignupRequest form,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "member/signup";
        }

        memberService.signup(form.toDto(), Role.ROLE_USER);
        return "redirect:/";
    }

    @GetMapping("signin")
    public String signin(SigninRequest form) {
        return "member/signin";
    }


    @GetMapping("mypage")
    public String mypage(Authentication authentication, Model model) {
        log.info("authentication : {}", authentication);
        String userId = authentication.getName();

        Member member = memberService.findById(userId);
        model.addAttribute("member", member);

        List<ASHOrderDto> orderList = ashOrderService.getOrdersByUserId(userId);
        model.addAttribute("orderList", orderList);

        return "member/mypage";
    }


    @DeleteMapping("/order/{orderId}/cancel")
    public String cancelOrder(@PathVariable Long orderId, RedirectAttributes redirectAttributes) {
        boolean success = ashOrderService.cancelOrder(orderId);

        redirectAttributes.addAttribute("status", success ? "success" : "fail");
        return "redirect:/member/order/cancel/result";
    }


    // 결과 화면을 보여줌
    @GetMapping("order/cancel/result")
    public String showCancelResult(@RequestParam String status, Model model) {
        model.addAttribute("status", status);
        return "order/orderCancelResult";
    }



    @PreAuthorize("hasAuthority('ROLE_ADMIN') or authentication.name == #id")
    @GetMapping("{id}")
    public String get(@PathVariable String id, Model model) {
        Member member = memberService.findById(id);
        model.addAttribute("member", member);
        return "member/mypage";
    }

    // NOTE cors
    // cross origin resource sharing
    // origin : protocol + host + port
    // allowCredentials : 쿠키, 인증 헤더 허용
    // allowMethods : cors 를 허용할 메소드 지정
    // allowHeaders : cors 를 허용할 http 헤더 지정
    //@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")

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

}
