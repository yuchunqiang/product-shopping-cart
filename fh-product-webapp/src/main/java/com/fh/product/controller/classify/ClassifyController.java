package com.fh.product.controller.classify;

import com.fh.product.aop.LogAnnotation;
import com.fh.product.service.classify.IClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("ClassifyController")
public class ClassifyController {
    @Autowired
    private IClassifyService classifyService;

    @RequestMapping(value = "queryClassifyList",method = RequestMethod.POST)
    @ResponseBody
    @LogAnnotation(methodInfo="查询分类")
    public Map queryClassifyList(@RequestParam("largeClassId") String largeClassId){
        return classifyService.queryClassifyList(largeClassId);
    }
}
