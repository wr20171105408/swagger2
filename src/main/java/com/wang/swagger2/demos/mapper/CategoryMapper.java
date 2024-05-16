package com.wang.swagger2.demos.mapper;

import com.wang.swagger2.demos.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 文章分类列表
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);

}
