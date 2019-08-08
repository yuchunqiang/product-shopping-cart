package com.fh.product.controller.classify;

import com.fh.product.bean.Classify;
import com.fh.product.service.classify.IClassIfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClassifyController {
    @Autowired
    private IClassIfyService classIfyService;

    @RequestMapping(value = "queryClassifyList",method = RequestMethod.POST)
    public Map queryClassifyList(@RequestParam("largeClassId") String largeClassId){
        System.out.println(largeClassId);
        List<Classify> classifyList=classIfyService.queryClassifyList(largeClassId);
        Map<String, Object> map=new HashMap<>();
        map.put("data", classifyList);
        return map;
    }
}
