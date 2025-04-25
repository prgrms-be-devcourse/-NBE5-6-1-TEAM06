package com.grepp.spring.app.controller.web.order;

import com.grepp.spring.app.controller.web.order.form.OrderRequest;
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
    public String showOrderPage(@ModelAttribute OrderRequest request, Model model){
//        OrderResponse response = orderService.prepareOrder(request);
//        model.addAttribute("order", response);
        return "order/order";
    }

    @PostMapping
    public String submitOrder(@ModelAttribute OrderRequest request, Model model){
//        OrderResponse response = orderService.saveOrder(request);
//        model.addAttribute("order", response);
        return "redirect:/order/complete";
    }

    //TODO : 장바구니 담기, 장바구니에서 -> 결제로 이동

//    @GetMapping
//    public String cartToOrder(@ModelAttribute CartRequest cartRequest) {
//        return "order/orderExample";
//    }


    @GetMapping("/cancel/result")
    public String cancelResult(@RequestParam Long orderId, Model model) {
        boolean success = orderService.cancelOrder(orderId);

        model.addAttribute("status", success ? "success" : "fail");

        return "order/orderCancelResult";
    }

}
