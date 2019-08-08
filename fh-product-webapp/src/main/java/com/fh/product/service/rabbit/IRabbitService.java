package com.fh.product.service.rabbit;

import com.fh.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@FeignClient("fh-rabbitmq-server")
public interface IRabbitService {

    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map addProduct(@RequestBody Product product);


}
