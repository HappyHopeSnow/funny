package com.weishu.web.recommend_food.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.recommend_food.entity.RecommendFood;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface RecommendFoodService {
    void save(RecommendFood recommendFood);

    void update(RecommendFood recommendFood);

    RecommendFood queryById(Long id);

    void del(RecommendFood recommendFood);

    PageInfo<RecommendFood> queryList(int pageNo, int pageSize);
}
