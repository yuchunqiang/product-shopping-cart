package com.fh.product.controller;




import com.alibaba.fastjson.JSONObject;
import com.fh.product.bean.Product;
import com.fh.product.service.product.IProductService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 消费者
 */
@Component
public class RabbitController {


    @Autowired
    private IProductService productService;

    @RabbitListener(queues = {"first-queue","second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
            //JSONObject jsonObject=JSONObject.fromObject(message);
            //Product product=(Product)JSONObject.toBean(jsonObject, Product.class);
            Product product = JSONObject.parseObject(message,Product.class);
            productService.addProduct(product);
//            Map map=new HashMap();
//            if (flag==0){
//                map.put("success",false);
//            }else {
//                map.put("success",true);
//            }
    }

}
