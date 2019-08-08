package com.fh.user.service.user;

import com.fh.user.bean.User;

public interface IUserService {

    User queryUserByName(String userName);
}
