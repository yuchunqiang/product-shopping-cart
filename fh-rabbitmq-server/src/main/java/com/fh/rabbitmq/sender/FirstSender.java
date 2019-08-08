package com.fh.rabbitmq.sender;

import com.alibaba.fastjson.JSON;
import com.fh.rabbitmq.bean.Product;
import com.fh.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@EnableAutoConfiguration
public class FirstSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public Map addProduct(@RequestBody Product product){
        UUID uuid = UUID.randomUUID();
        String uuid1= String.valueOf(uuid);
        CorrelationData correlationData=new CorrelationData(uuid1);
        String message= JSON.toJSONString(product);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTINGKEY2,message,correlationData);
        Map map=new HashMap();
        map.put("success",true);
        return map;
    }
}
