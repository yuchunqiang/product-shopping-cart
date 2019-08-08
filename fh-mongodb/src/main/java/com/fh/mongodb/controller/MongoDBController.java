package com.fh.mongodb.controller;

import com.fh.mongodb.bean.Log;
import com.fh.mongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoDBController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "addOptionLog",method = RequestMethod.POST)
    public void addOptionLog(@RequestBody Log Log){
        userService.addOptionLog(Log);
    }
}
