package com.fh.product.service.largeClass.impl;

import com.fh.product.bean.LargeClass;
import com.fh.product.dao.largeClass.ILargeClassDao;
import com.fh.product.service.largeClass.ILargeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LargeClassServiceImpl implements ILargeClassService {

    @Autowired
    private ILargeClassDao largeClassDao;
    @Override
    public List<LargeClass> queryLargeClassList() {
        return largeClassDao.queryLargeClassList();
    }
}
