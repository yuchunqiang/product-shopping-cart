package com.fh.product.dao.childClass;

import com.fh.product.bean.ChildClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IChildClassDao {
    List<ChildClass> queryChildClassList(String classifyId);
}
