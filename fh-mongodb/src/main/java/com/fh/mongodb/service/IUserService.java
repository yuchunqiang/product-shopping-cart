package com.fh.mongodb.service;

import com.fh.mongodb.bean.Log;

import java.util.List;

public interface IUserService {
    List<Log> queryAllUsers();

    void addOptionLog(Log user);


//    void updateUser(Log user);
//
//    void deleteUser(Log user);
//
//    Log findUserById(Log user);
}
