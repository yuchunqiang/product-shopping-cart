package com.fh.product.controller.user;

import com.fh.product.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@RequestMapping("UserController")
public class UserController {
    @Autowired
    private IUserService userService;


}
