package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ProductRepository {

    ProductDto findById(Long id);

    List<ProductDto> findAll();

    void save(ProductDto product);

    void update(ProductDto product);

    void delete(Long id);
}