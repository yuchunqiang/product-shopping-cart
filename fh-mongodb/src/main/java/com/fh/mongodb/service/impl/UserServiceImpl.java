package com.fh.mongodb.service.impl;

import com.fh.mongodb.bean.Log;
import com.fh.mongodb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Log> queryAllUsers() {
        return mongoTemplate.findAll(Log.class);
    }

    @Override
    public void addOptionLog(Log log) {
         log.setUserid(UUID.randomUUID().toString());
         mongoTemplate.save(log);
    }

//
//    @Override
//    public void updateUser(User user) {
//        mongoTemplate.save(user);
//    }
//
//    @Override
//    public void deleteUser(User user) {
//        mongoTemplate.remove(user);
//    }
//
//    @Override
//    public User findUserById(User user) {
//        return userDao.findUserById(user.getId());
//    }


}
