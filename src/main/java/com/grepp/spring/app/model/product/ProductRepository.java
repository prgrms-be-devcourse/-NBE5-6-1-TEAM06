package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.ProductDto;
import com.grepp.spring.app.model.product.mapper.ProductMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@RequiredArgsConstructor
public class ProductRepository {

    private final ProductMapper productMapper;

    public ProductDto findById(Long id) {
        return productMapper.findById(id);
    }

    public List<ProductDto> findAll() {
        return productMapper.findAll();
    }

    public List<ProductDto> adminFindAll() {return productMapper.adminFindAll();}

    public void save(ProductDto product) {
        productMapper.insert(product);
    }

    public void update(ProductDto product) {
        productMapper.update(product);
    }

    public void delete(Long id) {
        productMapper.delete(id);
    }
}