package com.fh.user.dao.user;

import com.fh.user.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IUserDao {
    User queryUserByName(String userName);
}
