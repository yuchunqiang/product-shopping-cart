package com.fh.product.service.product.impl;

import com.fh.product.bean.Product;
import com.fh.product.dao.product.IProductDao;
import com.fh.product.service.product.IProductService;
import com.fh.product.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> queryProductPageList(PageBean<Product> page, Product product) {
        long count=productDao.queryCount(product);
        page.setTotalcount(Integer.valueOf(String.valueOf(count)));
        Map<String,Object> map=new HashMap<>();
        map.put("product", product);
        map.put("page", page);
        List<Product> productList=productDao.queryProductPageList(map);
        return productList;
    }

    @Override
    public int addProduct(Product product) {
        return productDao.addProduct(product);
    }

    @Override
    public int delProductById(String productId) {
        return productDao.delProductById(productId);
    }

    @Override
    public Product queryProductById(String productId) {
        return productDao.queryProductById(productId);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }
}
