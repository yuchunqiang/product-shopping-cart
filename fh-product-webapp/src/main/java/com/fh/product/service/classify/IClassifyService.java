package com.fh.product.service.classify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("fh-product-server")
public interface IClassifyService {
    @RequestMapping(value = "queryClassifyList",method = RequestMethod.POST)
    public Map queryClassifyList(@RequestParam("largeClassId") String largeClassId);
}
