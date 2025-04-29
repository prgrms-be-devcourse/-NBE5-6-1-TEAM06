package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.IndexProductDto;
import com.grepp.spring.app.model.product.dto.ProductDto;
import com.grepp.spring.app.model.product.mapper.ProductMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;



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




    public ProductDto getProduct(Long id) {
        return productRepository.findById(id);
    }

    public List<IndexProductDto> getAllIndexProducts() {return productMapper.findAllProducts(); }


    public void addProduct(ProductDto product) {
        productRepository.save(product);
    }

    public void updateProduct(ProductDto product) {
        productMapper.update(product);
    }

    public void deleteProduct(Long id) {
        productMapper.delete(id);
    }

    public ProductDto getProductById(Long productId) {
        if (productId == null) {
            throw new IllegalArgumentException("상품 ID가 null입니다.");
        }
        return productRepository.findById(productId);
    }

    public List<ProductDto> adminGetAllProducts() {return productRepository.adminFindAll();}

    public void updateStock(Long productId, int stock) {productRepository.updateStock(productId, stock);}


}