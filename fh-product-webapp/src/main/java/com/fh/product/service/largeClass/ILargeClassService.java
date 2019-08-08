package com.fh.product.service.largeClass;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("fh-product-server")
public interface ILargeClassService {

    @RequestMapping(value = "queryLargeClassList",method = RequestMethod.POST)
    public Map queryLargeClassList();

}
