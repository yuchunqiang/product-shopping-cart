package com.fh.product.service.classify;

import com.fh.product.bean.Classify;

import java.util.List;

public interface IClassIfyService {
    List<Classify> queryClassifyList(String largeClassId);
}
