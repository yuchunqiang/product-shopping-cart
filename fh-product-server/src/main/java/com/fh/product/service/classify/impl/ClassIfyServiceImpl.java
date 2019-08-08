package com.fh.product.service.classify.impl;

import com.fh.product.bean.Classify;
import com.fh.product.dao.classify.IClassIfyDao;
import com.fh.product.service.classify.IClassIfyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassIfyServiceImpl implements IClassIfyService {
    @Autowired
    private IClassIfyDao classIfyDao;
    @Override
    public List<Classify> queryClassifyList(String largeClassId) {
        return classIfyDao.queryClassifyList(largeClassId);
    }
}
