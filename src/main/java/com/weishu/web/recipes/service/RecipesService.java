package com.weishu.web.recipes.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.recipes.entity.Recipes;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface RecipesService {
    void save(Recipes recipes);

    void update(Recipes recipes);

    Recipes queryById(Long id);

    void del(Recipes recipes);

    PageInfo<Recipes> queryList(int pageNo, int pageSize);
}
