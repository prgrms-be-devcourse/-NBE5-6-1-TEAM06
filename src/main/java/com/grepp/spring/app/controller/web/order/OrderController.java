package com.grepp.spring.app.controller.web.order;

import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.order.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
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
            return "orderComplete"; // orderComplete.jsp 를 보여줌
        }
        return "redirect:/";
    }
}
