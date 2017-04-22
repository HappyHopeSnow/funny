package com.weishu.web.day_food.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.day_food.entity.DayFood;

import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface DayFoodService {
    void save(DayFood dayFood);

    void update(DayFood dayFood);

    DayFood queryById(Long id);

    void del(DayFood dayFood);

    PageInfo<DayFood> queryList(int pageNo, int pageSize);

    List<DayFood> queryByDayIndex(Integer dayIndex);

    void recovery(DayFood dayFood);
}
