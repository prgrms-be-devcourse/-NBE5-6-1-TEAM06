package com.grepp.spring.app.controller.web.cart;

import com.grepp.spring.app.controller.web.cart.form.CartDetailsRequest;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("cartList")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public String CartList(Model model, Authentication authentication) {
        String email = authentication.getName();
        List<CartProduct> cartList = cartService.getCartListByUserId(email);

        model.addAttribute("cartList", cartList);
        return "cart/cartList";
    }

    @PostMapping
    public String modifyCart(@RequestParam String action, @RequestParam Long cartId, @RequestParam Long cartDetailsId, @RequestParam int productCnt, Model model) {
        if ("save".equals(action)) {
            cartService.modifyProductCnt(cartDetailsId, productCnt);
            return "redirect:/cartList";
        }
        return "redirect:/cartList";
    }

    @PostMapping("delete")
    public String deleteCartList(CartDetailsRequest cartDetailsRequest) {
        Long cartDetailsId = cartDetailsRequest.getCartDetailsId();
        cartService.delete(cartDetailsId);
        return "redirect:/cartList";
    }
}
