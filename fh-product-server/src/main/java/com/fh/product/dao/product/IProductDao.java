package com.fh.product.dao.product;

import com.fh.product.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IProductDao {

    long queryCount(Product product);

    List<Product> queryProductPageList(Map<String,Object> map);

    int addProduct(Product product);

    int delProductById(String productId);

    Product queryProductById(String productId);

    int updateProduct(Product product);
}
