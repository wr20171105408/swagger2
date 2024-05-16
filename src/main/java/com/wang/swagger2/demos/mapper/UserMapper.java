package com.wang.swagger2.demos.mapper;

import com.wang.swagger2.demos.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    // 依据用户名查询用户
    @Select("select * from user where username = #{userName}")
    User findByUserName(String userName);

    // 更新密码
    @Update("update user set password=#{md5String},update_time=now() where id=#{id}")
    void updatePwd(@Param("md5String") String md5String, @Param("id")Integer id);
}
