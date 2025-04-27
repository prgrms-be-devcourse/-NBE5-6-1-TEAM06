package com.grepp.spring.app.controller.web.order;

import com.grepp.spring.app.controller.web.cart.form.CartDetailsRequest;
import com.grepp.spring.app.controller.web.order.form.OrderRequest;
import com.grepp.spring.app.controller.web.order.response.OrderResponse;
import com.grepp.spring.app.model.cart.CartService;
import com.grepp.spring.app.model.cart.dto.CartProduct;
import com.grepp.spring.app.model.order.ASHOrderService;
import com.grepp.spring.app.model.order.OrderService;
import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import jakarta.servlet.ServletOutputStream;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private final ProductService productService;

    @Autowired
    private final OrderService orderService;
    private final CartService cartService;

    @GetMapping
    public String showOrderPage(@ModelAttribute OrderRequest request, Model model) {
        OrderResponse response = orderService.createOrder(request);
        model.addAttribute("order", response);

        List<ProductDto> products = productService.getAllProducts();

        // 여기 추가!
        for (ProductDto p : products) {
            System.out.println("==============================");
            System.out.println("Product name: " + p.getProductName());
            System.out.println("Product imgUrl: " + p.getProductImgUrl());
        }


        model.addAttribute("products", products);
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

    @GetMapping("cartOrderComplete")
    public String getCartOrderComplete() {
            return "order/cartOrderComplete";
    }

    @PostMapping("cartOrderComplete")
    public String postCartOrderComplete(@RequestParam String action, CartDetailsRequest cartDetailsRequest, Model model) {
        if ("cartListOrder".equals(action)) {
            CartProduct cartProduct  = cartService.orderCartList(cartDetailsRequest.getCartDetailsId());
            model.addAttribute("cartProduct", cartProduct);
            return "order/cartOrderComplete" ;
        }
        return "redirect:/orderList";
    }

    //TODO : 장바구니 담기, 장바구니에서 -> 결제로 이동
//    @GetMapping
//    public String cartToOrder(@ModelAttribute CartRequest cartRequest) {
//        return "order/orderExample";
//    }

}
