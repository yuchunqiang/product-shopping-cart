package com.fh.redis.controller.user;

import com.fh.redis.bean.Product;
import com.fh.redis.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 查询用户状态
     * @param skey
     * @return
     */
    @RequestMapping(value = "queryStatus",method = RequestMethod.POST)
    public Object queryStatus(@RequestParam("skey") String skey){
        return userService.getOpsForValue(skey);
    }

    /**
     * 增加错误次数
     * @param key
     */
    @RequestMapping(value = "addErrorLogin",method = RequestMethod.POST)
    public void addErrorLogin(@RequestParam("key") String key){
        userService.setOpsForValueIncrement(key);
    }

    /**
     * 查询错误次数
     * @param key
     * @return
     */
    @RequestMapping(value = "queryErrorLogin",method = RequestMethod.POST)
    public int queryErrorLogin(@RequestParam("key") String key){
        return (int) userService.getOpsForValue(key);
    }

    /**
     * 添加用户状态
     * @param skey
     */
    @RequestMapping(value = "addStatus",method = RequestMethod.POST)
    public void addStatus(@RequestParam("skey") String skey){
        userService.setOpsForValue(skey,1,3600L);
    }

    /**
     * 删除错误次数
     * @param key
     */
    @RequestMapping(value = "deleteErrorLogin",method = RequestMethod.POST)
    public void deleteErrorLogin(@RequestParam("key") String key){
        userService.getOpsForDelete(key);
    }

    /**
     * 存入商品信息
     * @param key
     * @param productId
     * @param product
     */
    @RequestMapping(value = "setHashOption",method = RequestMethod.POST)
    public void setHashOption(@RequestParam("key") String key, @RequestParam("productId") String productId, @RequestBody Product product){
        userService.setHashOption(key,productId,product);
    }

    /**
     * 查询该当前用户在购物车中的这个商品是否存在
     * @param key
     * @param productId
     * @return
     */
    @RequestMapping(value = "hasKey",method = RequestMethod.POST)
    public Boolean hasKey(@RequestParam("key") String key, @RequestParam("productId") String productId){
       return userService.hasKey(key,productId);
    }

    /**
     * 查询当前用户购物车中的某个商品信息
     * @param key
     * @param productId
     * @return
     */
    @RequestMapping(value = "hget",method = RequestMethod.POST)
    public Product hget(@RequestParam("key") String key, @RequestParam("productId") String productId){
        return (Product) userService.hget(key,productId);
    }

    /**
     * 查询当前用户购物车中的所有商品信息
     * @param key
     * @return
     */
    @RequestMapping(value = "hgetList",method = RequestMethod.POST)
    public List hgetList(@RequestParam("key") String key){
        return userService.hgetList(key);
    }

    /**
     * 删除当前用户购物车中的某个商品信息
     * @param key
     * @param productId
     */
    @RequestMapping(value = "deleteHash",method = RequestMethod.POST)
    public void deleteHash(@RequestParam("key") String key, @RequestParam("productId") String productId){
        userService.deleteHash(key,productId);
    }





}
