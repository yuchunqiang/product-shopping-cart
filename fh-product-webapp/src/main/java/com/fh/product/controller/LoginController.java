package com.fh.product.controller;

import com.fh.product.bean.User;
import com.fh.product.response.ResponseEnum;
import com.fh.product.response.ResponseServer;
import com.fh.product.service.user.IUserRedisService;
import com.fh.product.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableAutoConfiguration
@RequestMapping("LoginController")
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRedisService userRedisService;

    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("loginUser")
    @ResponseBody
    public ResponseServer loginUser(User user,HttpServletRequest request){
//        boolean issheck=CaptchaUtil.isVerified(user.getCode(), user.getImgCode().toLowerCase(), request);
//        if (!issheck) {
//            return ResponseServer.error(ResponseEnum.IDENTIFYING_CODE);
//        }
        //用户是否存在
        User tuser=userService.queryUserByName(user.getUserName());
        if (tuser==null) {
            return ResponseServer.error(ResponseEnum.USER_NO_EXIST);
        }
        String key=tuser.getUserId()+"errorLogin";
        String skey=tuser.getUserId()+"status";
        Object status=userRedisService.queryStatus(skey);
        //验证账号是否锁定
        if (status!=null) {
            return ResponseServer.error(ResponseEnum.ACCOUNT_LOCKED);
         }
        if (!tuser.getUserPwd().equals(user.getUserPwd())){
            userRedisService.addErrorLogin(key);
            int errorLogin=userRedisService.queryErrorLogin(key);
            if (errorLogin==3){
                userRedisService.addStatus(skey);
            }
            return ResponseServer.error(ResponseEnum.PASSWORD_ERROR);
        }
         userRedisService.deleteErrorLogin(key);
         request.getSession().setAttribute("user",tuser);
         return ResponseServer.success(ResponseEnum.SUCCESS);
    }
}
