package com.fh.user.controller.user;

import com.fh.user.bean.User;
import com.fh.user.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "queryUserByName",method = RequestMethod.POST)
    public User queryUserByName(@RequestParam("userName") String userName){
        User user=userService.queryUserByName(userName);
        return  user;
    }

}


