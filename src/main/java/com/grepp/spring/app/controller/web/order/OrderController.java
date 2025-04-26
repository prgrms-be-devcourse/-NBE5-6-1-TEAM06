package com.grepp.spring.app.controller.web.order;

import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.order.ASHOrderService;
import com.grepp.spring.app.model.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String showOrderPage(@ModelAttribute OrderRequest request, Model model) {
        OrderResponse response = orderService.createOrder(request);
        model.addAttribute("order", response);
        return "/order/order";
    }

    @PostMapping
    public String handleOrder(
        @RequestParam("action") String action,
        @ModelAttribute OrderRequest request,
        Model model) {

        if (action.equals("cart")) {
            //main 통합 후 주석해제
//            cartService.addToCart(request);
            return "redirect:/member/cartList";
        } else if (action.equals("order")) {
            OrderResponse response = orderService.createOrder(request);
            model.addAttribute("order", response);
            return "/order/orderComplete";
        }
        return "redirect:/";
    }

    //TODO : 장바구니 담기, 장바구니에서 -> 결제로 이동
//    @GetMapping
//    public String cartToOrder(@ModelAttribute CartRequest cartRequest) {
//        return "order/orderExample";
//    }

}
