package com.fh.redis.service.user.impl;	

import com.fh.redis.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 获取key和value值存入redis缓存
     * @param key
     * @param value
     */
    @Override
    public void setOpsForValue(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 根据key从redis中查询数据
     * @param key
     * @return
     */
    @Override
    public Object getOpsForValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void getOpsForDelete(String key) {
        redisTemplate.delete(key);
    }

    /**
     *设置临时数据存入  可设置时间
     * @param key
     * @param value
     * @param timeout
     */
    @Override
    public void setOpsForValue(String key, Object value, Long timeout) {
        redisTemplate.opsForValue().set(key,value,timeout,TimeUnit.SECONDS);
    }

    /**
     *放多条数据根据map里的键值对存入redis
     * @param map
     */
    @Override
    public void setOpsForValue(Map<String, Object> map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 计数器每次加一
     * @param key
     */
    @Override
    public void setOpsForValueIncrement(String key) {
        redisTemplate.opsForValue().increment(key,1);

    }

    /**
     *将对象从最左侧插入list集合
     * @param key
     * @param value
     */
    @Override
    public void setOpsList(String key, Object value) {
        redisTemplate.opsForList().leftPush(key,value);
    }

    /**
     *存入多个对象
     * @param key
     * @param values
     */
    @Override
    public void setOpsList(String key, Collection values) {
        redisTemplate.opsForList().leftPushAll(key,values);
    }

    /**
     * 查询数据（名称，开始下标，结束下标  -1为所有）
     * @param key
     * @param start
     * @param end
     * @return
     */
    @Override
    public Object getOpsList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key,start,end);
    }

    /**
     * 删除
     * @param key
     * @param count
     * @param value
     */
    @Override
    public void getOpsListRemove(String key, long count, Object value) {
        redisTemplate.opsForList().remove(key,count,value);
    }

    /**
     * 增加hash
     * @param key
     * @param objKey
     * @param value
     */
    @Override
    public void setHashOption(String key, String objKey, Object value) {
        redisTemplate.opsForHash().put(key,objKey,value);
    }

    /**
     * 判断是否存在
     * @param key
     * @param productId
     * @return
     */
    @Override
    public Boolean hasKey(String key, String productId) {
        return redisTemplate.opsForHash().hasKey(key,productId);
    }


    /**
     *查询商品信息
     * @param key
     * @param productId
     * @return
     */
    @Override
    public Object hget(String key, String productId) {
        return redisTemplate.opsForHash().get(key,productId);
    }

    /**
     * 查询购物车信息
     * @param key
     * @return
     */
    @Override
    public List hgetList(String key) {
        return redisTemplate.opsForHash().values(key);
    }

    /**
     * 删除单个商品
     * @param key
     * @param productId
     */
    @Override
    public void deleteHash(String key, String productId) {
        redisTemplate.opsForHash().delete(key,productId);
    }


}
