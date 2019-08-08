package com.fh.product.service.product;

import com.fh.product.bean.Product;
import com.fh.product.util.PageBean;

import java.util.List;

public interface IProductService {

    List<Product> queryProductPageList(PageBean<Product> page, Product product);

    int addProduct(Product product);

    int delProductById(String productId);

    Product queryProductById(String productId);

    int updateProduct(Product product);
}
