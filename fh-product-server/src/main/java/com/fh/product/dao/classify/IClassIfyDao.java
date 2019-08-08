package com.fh.product.dao.classify;

import com.fh.product.bean.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IClassIfyDao {
    List<Classify> queryClassifyList(String largeClassId);
}
