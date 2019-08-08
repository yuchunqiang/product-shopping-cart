package com.fh.product.service.user;

import com.fh.product.bean.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("fh-user-server")
public interface IUserService {

    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    public User queryUserByName(@RequestParam("userName") String userName);

}
