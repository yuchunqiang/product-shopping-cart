package com.fh.product.controller.largeClass;

import com.fh.product.aop.LogAnnotation;
import com.fh.product.service.largeClass.ILargeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@EnableAutoConfiguration
@RequestMapping("LargeClassController")
public class LargeClassController {

    @Autowired
    private ILargeClassService largeClassService;

    @RequestMapping("queryLargeClassList")
    @ResponseBody
    @LogAnnotation(methodInfo="查询大类")
    public Map queryLargeClassList(){
       return largeClassService.queryLargeClassList();
    }
}
