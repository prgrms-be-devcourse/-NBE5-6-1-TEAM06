package com.grepp.spring.app.controller.web.admin;

import com.grepp.spring.app.controller.web.member.form.SignupRequest;
import com.grepp.spring.app.model.auth.code.Role;
import com.grepp.spring.app.model.member.MemberService;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.order.dto.OrderDto;
import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ProductService productService;


    @GetMapping("signup")
    public String signup(SignupRequest form){
        return "admin/signup";
    }

    @PostMapping("signup")
    public String signup(@Valid SignupRequest form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "admin/signup";
        }

        memberService.signup(form.toDto(), Role.ROLE_ADMIN);
        return "redirect:/";
    }

    @GetMapping("dashboard")
    public String orderList(Model model) {
        List<OrderDto> orders = orderService.getAllOrders();
        List<ProductDto> products = productService.adminGetAllProducts();

        model.addAttribute("products", products);
        model.addAttribute("orders", orders);
        return "admin/dashboard";
    }

    @DeleteMapping("deleteOrder")
    public String deleteOrder(@RequestParam("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("updateStock")
    public String updateStock(@RequestParam("productId") Long productId,
                              @RequestParam("stock") int stock) {
        productService.updateStock(productId, stock);
        return "redirect:/admin/dashboard";
    }

}