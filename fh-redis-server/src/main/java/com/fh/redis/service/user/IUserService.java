package com.fh.redis.service.user;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IUserService {

    /**
     * 获取key和value值存入redis缓存
     * @param key
     * @param value
     */
    public void setOpsForValue(String key, Object value);


    /**
     * 根据key从redis中查询数据
     * @param key
     * @return
     */
    public Object getOpsForValue(String key);

    /**
     * 根据key从redis中删除数据
     * @param key
     * @return
     */
    public void getOpsForDelete(String key);


    /**
     *设置临时数据存入  可设置时间
     * @param key
     * @param value
     * @param timeout
     */
    public void setOpsForValue(String key, Object value, Long timeout);

    /**
     *放多条数据根据map里的键值对存入redis
     * @param map
     */
    public void setOpsForValue(Map<String, Object> map);

    /**
     * 计数器
     */
    public void setOpsForValueIncrement(String key);

    /**
     *将对象放入list集合中
     * @param key
     * @param value
     */
    public void setOpsList(String key, Object value);

    /**
     * 存入多个对象
     * @param key
     * @param values
     */
    public void setOpsList(String key, Collection values);


    /**
     * 查询数据（名称，开始下标，结束下标  -1为所有）
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Object getOpsList(String key, long start, long end);

    /**
     * 删除
     * @param key
     * @param count
     * @param value
     */
    public void getOpsListRemove(String key, long count, Object value);

    /**
     * 增加hash
     * @param key
     * @param objKey
     * @param value
     */
    public void setHashOption(String key,String objKey,Object value);


    /**
     * 判断是否存在
     * @param key
     * @param productId
     * @return
     */
    Boolean hasKey(String key, String productId);

    /**
     * 查询商品信息
     * @param key
     * @param productId
     * @return
     */
    public Object hget(String key, String productId);

    /**
     * 查询购物车信息
     * @param key
     * @return
     */
    List hgetList(String key);

    /**
     * 删除hash中的数据
     * @param key
     * @param productId
     */
    public void deleteHash(String key, String productId);
}
