package com.fh.product.controller.childClass;

import com.fh.product.bean.ChildClass;
import com.fh.product.service.childClass.IChildClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ChildClassController {
    @Autowired
    private IChildClassService childClassService;

    @RequestMapping(value = "queryChildClassList",method = RequestMethod.POST)
    public Map queryChildClassList(@RequestParam("classifyId") String classifyId){
        List<ChildClass> childClassList=childClassService.queryChildClassList(classifyId);
        Map<String, Object> map=new HashMap<>();
        map.put("data", childClassList);
        return map;
    }

}
