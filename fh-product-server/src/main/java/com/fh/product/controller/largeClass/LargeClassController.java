package com.fh.product.controller.largeClass;

import com.fh.product.bean.LargeClass;
import com.fh.product.service.largeClass.ILargeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LargeClassController {
    @Autowired
    private ILargeClassService largeClassService;

    @RequestMapping(value = "queryLargeClassList",method = RequestMethod.POST)
    public Map queryLargeClassList(){
        List<LargeClass> largeClassList=largeClassService.queryLargeClassList();
        Map<String, Object> map=new HashMap<>();
        map.put("data", largeClassList);
        return map;
    }
}
