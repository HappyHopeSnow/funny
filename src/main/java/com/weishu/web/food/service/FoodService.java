package com.weishu.web.food.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.food.entity.Food;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface FoodService {
    void save(Food food);

    void update(Food food);

    Food queryById(Long id);

    void del(Food food);

    PageInfo<Food> queryList(int pageNo, int pageSize);

    void recovery(Food food);
}
