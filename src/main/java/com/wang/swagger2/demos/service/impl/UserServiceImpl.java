package com.wang.swagger2.demos.service.impl;

import com.wang.swagger2.demos.mapper.UserMapper;
import com.wang.swagger2.demos.pojo.User;
import com.wang.swagger2.demos.service.UserService;
import com.wang.swagger2.demos.utils.Md5Util;
import com.wang.swagger2.demos.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userName) {
        User u = userMapper.findByUserName(userName);
        return u;
    }

    // 更新密码
    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(Md5Util.getMD5String(newPwd),id);
    }
}
