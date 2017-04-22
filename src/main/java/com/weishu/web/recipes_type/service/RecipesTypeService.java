package com.weishu.web.recipes_type.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.recipes_type.entity.RecipesType;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface RecipesTypeService {
    void save(RecipesType recipesType);

    void update(RecipesType recipesType);

    RecipesType queryById(Long id);

    void del(RecipesType recipesType);

    PageInfo<RecipesType> queryList(int pageNo, int pageSize);
}
