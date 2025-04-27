package com.grepp.spring;

import com.grepp.spring.app.model.product.ProductService;
import com.grepp.spring.app.model.product.dto.ProductDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {


    private final ProductService productService;

//    @GetMapping()
//    public String showProducts(Model model) {
//        List<IndexProductDto> productList = productService.getAllIndexProducts();
//        model.addAttribute("products", productList);
//
//        return "index";
//    }

    @GetMapping()
    public String index(Model model) {
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }
}

