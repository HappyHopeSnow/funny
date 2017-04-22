package com.weishu.web.nutrition.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.nutrition.entity.Nutrition;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface NutritionService {
    void save(Nutrition nutrition);

    void update(Nutrition nutrition);

    Nutrition queryById(Long id);

    void del(Nutrition nutrition);

    PageInfo<Nutrition> queryList(long foodId, int pageNo, int pageSize);

    void recovery(Nutrition nutrition);
}
