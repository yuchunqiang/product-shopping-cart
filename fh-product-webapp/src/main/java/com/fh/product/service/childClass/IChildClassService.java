package com.fh.product.service.childClass;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("fh-product-server")
public interface IChildClassService {

    @RequestMapping(value = "queryChildClassList",method = RequestMethod.POST)
    public Map queryChildClassList(@RequestParam("classifyId") String classifyId);
}
