package com.grepp.spring.app.controller.web.admin;

import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.OrderDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
//@PreAuthorize("hasRole('ADMIN')")

public class AdminController {

    private final OrderService orderService;

    @GetMapping("dashboard")
    public String orderList(Model model) {
        List<OrderDto> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "admin/dashboard";
    }

    @DeleteMapping("orderList")
    public String deleteOrder(@RequestParam Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/admin/dashboard";
    }

}
