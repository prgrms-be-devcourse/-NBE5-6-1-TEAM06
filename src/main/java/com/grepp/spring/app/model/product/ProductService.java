package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.ProductDto;
import java.util.List;
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
        return productRepository.findAll();
    }

    public List<ProductDto> adminGetAllProducts() {return productRepository.adminFindAll();}

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