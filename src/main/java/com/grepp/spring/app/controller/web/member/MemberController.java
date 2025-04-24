package com.grepp.spring.app.controller.web.member;

import com.grepp.spring.app.controller.web.member.form.CartRequest;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import com.grepp.spring.app.model.member.MemberService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("member")
public class MemberController {

    //TODO : 장바구니 조회, 장바구니 수정, 장바구니 삭제

    private final MemberService memberService;
    private final CartService cartService;

    @GetMapping("cartList")
    public String CartList(Model model) {
        List<CartProduct> cartList = cartService.getCartList();
        model.addAttribute("cartList", cartList);
        return "member/cartList";
    }

    @PutMapping("cartList")
    public String modifyCart(@ModelAttribute CartRequest cartRequest) {
        return "redirect:/member/cartList";
    }

    @DeleteMapping("cartList")
    public String deleteCartList(@ModelAttribute CartRequest cartRequest) {
        return "redirect:/member/cartList";
    }


}
