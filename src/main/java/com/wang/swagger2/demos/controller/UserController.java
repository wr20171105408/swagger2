package com.wang.swagger2.demos.controller;


import com.wang.swagger2.demos.pojo.Result;
import com.wang.swagger2.demos.pojo.User;
import com.wang.swagger2.demos.service.UserService;
import com.wang.swagger2.demos.utils.JwtUtil;
import com.wang.swagger2.demos.utils.Md5Util;
import com.wang.swagger2.demos.utils.ThreadLocalUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
@Validated
@Api(value = "用户管理",tags = "用户管理的相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    @ApiOperation("获取用户列表")

    public Result getUsers() {
        return Result.success("获取用户列表");
    }

    @PostMapping("/login")
    @ApiOperation("登录")
    @ApiImplicitParams(
            { @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String",paramType="query"),
            @ApiImplicitParam(name = "passWord", value = "密码", required = true, dataType = "String",paramType="query")
            })

    public Result login(@Pattern(regexp = "^\\S{5,16}$") String userName,
                        @Pattern(regexp = "^\\S{5,16}$") String passWord) {
        // 查询用户
        User loginUser = userService.findByUserName(userName);
        if (loginUser == null) {
            return Result.error("用户名错误!");
        }
        // 判断密码是否正确 loginUser中的密码是密文
        if (Md5Util.checkPassword(passWord,loginUser.getPassword())) {
            // 登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            claims.put("token",token);
            return Result.success(token);
        }
        return Result.error("密码错误!");
    }

    @PatchMapping("/updatePwd")
    @ApiOperation("更新密码")
    @ApiImplicitParam(name = "params", value = "参数集", required = true, dataType = "map",paramType="body")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数没填好"),
            @ApiResponse(code = 401, message = "token过期或者没登录")
    })
    public Result<User> updatePwd(@RequestBody Map<String,String> params) {
        // 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        System.out.println(StringUtils.hasLength(oldPwd));
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {

            return Result.error(400,"缺少必要的参数!");
        }
        // 判断原密码是否正确
        Map<String,Object> map = ThreadLocalUtil.get();
        String userName = (String) map.get("username");
        User loginUser = userService.findByUserName(userName);
        if (!Md5Util.checkPassword(oldPwd,loginUser.getPassword())) {

            return Result.error("原密码填写不正确!");
        }
        // newPwd 与 rePwd 是否一致
        if (!newPwd.equals(rePwd)) {

            return Result.error("两次填写的新密码填写不一致!");
        }
        // 更新密码
        userService.updatePwd(newPwd);
        return Result.success();
    }
}
