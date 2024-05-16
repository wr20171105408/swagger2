package com.wang.swagger2.demos.pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(description= "返回响应数据")
public class Result<T> {
    private Integer code;//业务状态码  0-成功  1-失败
    private String msg;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(400, message, null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg, null);
    }
}



