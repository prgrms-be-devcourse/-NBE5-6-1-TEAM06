package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.ProductDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductDto getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<ProductDto> getAllProducts() {
        List<ProductDto> products = productRepository.findAll();
        return products.stream().map(product -> {
            ProductDto dto = new ProductDto();
            dto.setProductId(product.getProductId());
            dto.setProductName(product.getProductName());
            dto.setPrice(product.getPrice());
            dto.setCategory(product.getCategory());

            if (product.getProductImgUrl() != null && !product.getProductImgUrl().isEmpty()) {
                dto.setProductImgUrl(product.getProductImgUrl());
            } else {
                dto.setProductImgUrl("sample-1.jpeg");
            }

            return dto;
        }).collect(Collectors.toList());
    }

    public void addProduct(ProductDto product) {
        productRepository.save(product);
    }

    public void updateProduct(ProductDto product) {
        productRepository.update(product);
    }

    public void deleteProduct(Long id) {
        productRepository.delete(id);
    }
}