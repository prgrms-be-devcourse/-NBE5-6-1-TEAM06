package com.grepp.spring.app.model.product;

import com.grepp.spring.app.model.product.dto.IndexProductDto;
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

    List<ProductDto> adminFindAll();

    void updateStock(Long productId, int stock);

//    public List<IndexProductDto> findAllProducts() {
//        return productMapper.findAllProducts();
//    }

//    public void save(ProductDto product) {
//        productMapper.insert(product);
//    }

//    public void update(ProductDto product) {
//        productMapper.update(product);
//    }

//    public void delete(Long id) {
//        productMapper.delete(id);
//    }
}