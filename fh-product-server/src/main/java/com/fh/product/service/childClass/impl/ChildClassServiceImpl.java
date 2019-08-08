package com.fh.product.service.childClass.impl;

import com.fh.product.bean.ChildClass;
import com.fh.product.dao.childClass.IChildClassDao;
import com.fh.product.service.childClass.IChildClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildClassServiceImpl implements IChildClassService {

    @Autowired
    private IChildClassDao childClassDao;
    @Override
    public List<ChildClass> queryChildClassList(String classifyId) {
        return childClassDao.queryChildClassList(classifyId);
    }
}
