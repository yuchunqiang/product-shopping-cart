package com.fh.product.controller.childClass;

import com.fh.product.aop.LogAnnotation;
import com.fh.product.service.childClass.IChildClassService;
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
@RequestMapping("ChildClassController")
public class ChildClassController {
    @Autowired
    private IChildClassService childClassService;


    @RequestMapping(value = "queryChildClassList",method = RequestMethod.POST)
    @ResponseBody
    @LogAnnotation(methodInfo="查询小类")
    public Map queryChildClassList(@RequestParam("classifyId") String classifyId){
        return childClassService.queryChildClassList(classifyId);
    }
}
