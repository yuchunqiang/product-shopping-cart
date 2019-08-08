package com.fh.product.controller.product;

import com.fh.product.bean.Product;
import com.fh.product.service.product.IProductService;
import com.fh.product.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @RequestMapping(value = "queryProductPageList",method = RequestMethod.POST)
    public Map queryProductPageList(Product product,@RequestParam("draw") Integer draw, @RequestParam("start") Integer start, @RequestParam("length") Integer length){
        PageBean<Product> page = new PageBean<Product>();
        page.setStartIndax(start);
        page.setPagesize(length);
        List<Product> productList=productService.queryProductPageList(page,product);

        Map<String, Object> map=new HashMap<>();
        map.put("draw", draw);
        map.put("recordsTotal", page.getTotalcount());
        map.put("recordsFiltered", page.getTotalcount());
        map.put("data", productList);
        return map;
    }


    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map addProduct(@RequestBody Product product){
        int flag=productService.addProduct(product);
        Map map=new HashMap();
        if (flag==0){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "delProductById",method = RequestMethod.POST)
    public Map delProductById(@RequestParam("productId") String productId){
        int flag=productService.delProductById(productId);
        Map map=new HashMap();
        if (flag==0){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "queryProductById",method = RequestMethod.POST)
    public Map queryProductById(@RequestParam("productId") String productId){
        Product product=productService.queryProductById(productId);
        Map map=new HashMap();
        if (product!=null){
            map.put("success",true);
            map.put("data",product);
        }else {
            map.put("success",false);
        }
        return map;
    }

    @RequestMapping(value = "updateProduct",method = RequestMethod.POST)
    public Map updateProduct(@RequestBody Product product){
        int flag=productService.updateProduct(product);
        Map map=new HashMap();
        if (flag==0){
            map.put("success",false);
        }else {
            map.put("success",true);
        }
        return map;
    }

    @RequestMapping(value = "queryProductByIdCart",method = RequestMethod.POST)
    public Product queryProductByIdCart(@RequestParam("productId") String productId){
        Product product=productService.queryProductById(productId);
        return product;
    }





}
