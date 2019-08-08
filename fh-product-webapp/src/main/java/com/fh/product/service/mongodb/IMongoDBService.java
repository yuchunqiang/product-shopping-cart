package com.fh.product.service.mongodb;

import com.fh.product.aop.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("fh-mongodb-server")
public interface IMongoDBService {

    @RequestMapping(value = "addOptionLog",method = RequestMethod.POST)
    public void addOptionLog(@RequestBody Log Log);

}
