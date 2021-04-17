package com.bjtu.service;

import com.bjtu.bean.User;
import com.bjtu.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public String checkUsername(String username) {
        return userMapper.selectByUsername(username) == null ? "101" : "102";
    }

    public String register(User user) {
        user.setIsAdmin(false);
        return userMapper.insert(user) == 1 ? "success" : "failure";
    }

    public String login(User loginUser, HttpSession httpSession) {
        User user = userMapper.selectByUsername(loginUser.getUsername());
        if (user == null) {
            return "101";
        } else if (user.getPassword().equals(loginUser.getPassword())) {
            httpSession.setAttribute("user", user);
            return "100";
        } else {
            return "102";
        }
    }

    public boolean changePassword(int userId, String newPassword) {

        return false;
    }

    // 注销账户
    public boolean cancelAccount() {
        return false;
    }

}
