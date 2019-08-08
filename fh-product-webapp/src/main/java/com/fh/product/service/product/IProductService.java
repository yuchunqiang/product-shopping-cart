package com.fh.product.service.product;

import com.fh.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("fh-product-server")
public interface IProductService {
	
    @RequestMapping(value = "queryProductPageList",method = RequestMethod.GET)
    public Map queryProductPageList(Product product, @RequestParam("draw") Integer draw, @RequestParam("start") Integer start, @RequestParam("length") Integer length);

    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map addProduct(@RequestBody Product product);

    @RequestMapping(value = "delProductById",method = RequestMethod.POST)
    public Map delProductById(@RequestParam("productId") String productId);

    @RequestMapping(value = "queryProductById",method = RequestMethod.POST)
    public Map queryProductById(@RequestParam("productId") String productId);

    @RequestMapping(value = "updateProduct",method = RequestMethod.POST)
    public Map updateProduct(@RequestBody Product product);

    @RequestMapping(value = "queryProductByIdCart",method = RequestMethod.POST)
    public Product queryProductByIdCart(@RequestParam("productId") String productId);


}
