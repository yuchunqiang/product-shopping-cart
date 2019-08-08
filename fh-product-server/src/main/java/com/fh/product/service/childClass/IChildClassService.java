package com.fh.product.service.childClass;

import com.fh.product.bean.ChildClass;

import java.util.List;

public interface IChildClassService {
    List<ChildClass> queryChildClassList(String classifyId);
}
