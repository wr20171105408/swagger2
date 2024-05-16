package com.wang.swagger2.demos.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "用户",description = "用户信息")
public class User {
    @NotNull
    private Integer id;//主键ID

    @ApiModelProperty("用户名")
    private String username;//用户名

    @ApiModelProperty("密码")
    @JsonIgnore // 最终将当前对象转换成json对象时忽视password字段
    private String password;//密码

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    @ApiModelProperty("昵称")
    private String nickname;//昵称

    @NotEmpty
    @Email
    @ApiModelProperty("邮箱")
    private String email;//邮箱

    @ApiModelProperty("用户头像地址")
    private String userPic;//用户头像地址
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;//创建时间
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;//更新时间
}
