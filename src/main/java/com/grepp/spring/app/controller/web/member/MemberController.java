package com.grepp.spring.app.controller.web.member;

import com.grepp.spring.app.controller.web.member.form.SigninRequest;
import com.grepp.spring.app.controller.web.member.form.SignupRequest;
import com.grepp.spring.app.model.auth.code.Role;
import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.member.dto.Member;
import com.grepp.spring.app.model.order.ASHOrderService;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.ASHOrderDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {


    private final MemberService memberService;
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
}
