package com.fh.user.service.user.impl;

import com.fh.user.bean.User;
import com.fh.user.dao.user.IUserDao;
import com.fh.user.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public User queryUserByName(String userName) {
        return userDao.queryUserByName(userName);
    }
}
