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
import org.springframework.web.context.request.RequestScope;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String showOrderPage(@ModelAttribute OrderRequest request, Model model){
//        OrderResponse response = orderService.prepareOrder(request);
//        model.addAttribute("order", response);
        return "/order/order";
    }

    @PostMapping("/")
    public String submitOrder(@ModelAttribute OrderRequest request, Model model){
//        OrderResponse response = orderService.saveOrder(request);
//        model.addAttribute("order", response);
        return "redirect:/order/complete";
    }
}
