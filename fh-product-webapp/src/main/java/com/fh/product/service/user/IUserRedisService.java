package com.fh.product.service.user;

import com.fh.product.bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("fh-redis-server")
public interface IUserRedisService {

    /**
     * 查询用户状态
     * @param skey
     * @return
     */
    @RequestMapping(value = "queryStatus",method = RequestMethod.POST)
    public Object queryStatus(@RequestParam("skey") String skey);

    /**
     * 增加错误次数
     * @param key
     */
    @RequestMapping(value = "addErrorLogin",method = RequestMethod.POST)
    public void addErrorLogin(@RequestParam("key") String key);

    /**
     * 查询错误次数
     * @param key
     * @return
     */
    @RequestMapping(value = "queryErrorLogin",method = RequestMethod.POST)
    public int queryErrorLogin(@RequestParam("key") String key);

    /**
     * 添加用户状态
     * @param skey
     */
    @RequestMapping(value = "addStatus",method = RequestMethod.POST)
    public void addStatus(@RequestParam("skey") String skey);

    /**
     * 删除错误次数
     * @param key
     */
    @RequestMapping(value = "deleteErrorLogin",method = RequestMethod.POST)
    public void deleteErrorLogin(@RequestParam("key") String key);

    /**
     * 存入商品信息
     * @param key
     * @param productId
     * @param product
     */
    @RequestMapping(value = "setHashOption",method = RequestMethod.POST)
    public void setHashOption(@RequestParam("key") String key, @RequestParam("productId") String productId, @RequestBody Product product);

    /**
     * 查询该当前用户在购物车中的这个商品是否存在
     * @param key
     * @param productId
     * @return
     */
    @RequestMapping(value = "hasKey",method = RequestMethod.POST)
    public Boolean hasKey(@RequestParam("key") String key, @RequestParam("productId") String productId);

    /**
     * 查询当前用户购物车中的某个商品信息
     * @param key
     * @param productId
     * @return
     */
    @RequestMapping(value = "hget",method = RequestMethod.POST)
    public Product hget(@RequestParam("key") String key, @RequestParam("productId") String productId);

    /**
     * 查询当前用户购物车中的所有商品信息
     * @param key
     * @return
     */
    @RequestMapping(value = "hgetList",method = RequestMethod.POST)
    public List hgetList(@RequestParam("key") String key);

    /**
     * 删除当前用户购物车中的某个商品信息
     * @param key
     * @param productId
     */
    @RequestMapping(value = "deleteHash",method = RequestMethod.POST)
    public void deleteHash(@RequestParam("key") String key, @RequestParam("productId") String productId);
}
