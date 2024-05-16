package com.wang.swagger2.demos.service.impl;

import com.wang.swagger2.demos.mapper.CategoryMapper;
import com.wang.swagger2.demos.pojo.Category;
import com.wang.swagger2.demos.service.CategoryService;
import com.wang.swagger2.demos.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    // 文章分类列表
    @Override
    public List<Category> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        return categoryMapper.list(userId);
    }

}
