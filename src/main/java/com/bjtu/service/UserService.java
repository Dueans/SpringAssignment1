package com.bjtu.service;

import com.bjtu.bean.User;
import com.bjtu.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean register(String username, String password) {
        User user = new User(null, username, password, false);
        return userMapper.insert(user) == 1;
    }

    public boolean login(String username,String password){
        return password.equals(userMapper.selectByUsername(username).getPassword());
    }
}
