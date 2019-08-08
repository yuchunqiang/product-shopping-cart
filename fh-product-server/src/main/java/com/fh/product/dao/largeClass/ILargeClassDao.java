package com.fh.product.dao.largeClass;

import com.fh.product.bean.LargeClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ILargeClassDao {
    List<LargeClass> queryLargeClassList();
}
