package com.grepp.spring.app.controller.web.cart;

import com.grepp.spring.app.controller.web.cart.form.CartDetatilsRequest;
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

    //    //TODO : 수정 로직 완료, 장바구니 -> 결제  로직
    @PostMapping
    public String modifyCart(CartDetatilsRequest cartDetatilsRequest, @RequestParam String action) {
        int productCnt = cartDetatilsRequest.getProductCnt();
        long cartDetailsId = cartDetatilsRequest.getCartDetailsId();
        if ("save".equals(action)) {
            cartService.modifyProductCnt(cartDetailsId, productCnt);
            return "redirect:/cartList";
        }
        if ("order".equals(action)) {
            cartService.orderCartList(cartDetailsId);
            return "redirect:/order" ;
        }

        if ("orderAll".equals(action)) {
            cartService.orderAllCartList();
            return "redirect:/order" ;
        }
        return "redirect:/cartList";
    }

    @PostMapping("delete")
    public String deleteCartList(CartDetatilsRequest cartDetatilsRequest) {
        long cartDetailsId = cartDetatilsRequest.getCartDetailsId();
        cartService.delete(cartDetailsId);
        return "redirect:/cartList";
    }
}
