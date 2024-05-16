package com.wang.swagger2.demos.service;


import com.wang.swagger2.demos.pojo.User;

public interface UserService {
    // 依据用户名查询用户
    User findByUserName(String userName);

    // 更新密码
    void updatePwd(String newPwd);
}
