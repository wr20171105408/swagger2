package com.wang.swagger2.demos.controller;

import com.wang.swagger2.demos.pojo.Category;
import com.wang.swagger2.demos.pojo.Result;
import com.wang.swagger2.demos.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value = "分类管理",tags = "分类管理的相关接口")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @ApiOperation("获取分类列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "参数没填好"),
            @ApiResponse(code = 401, message = "token过期或者没登录")
    })
    @GetMapping()
    public Result<List<Category>> category() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }
}
