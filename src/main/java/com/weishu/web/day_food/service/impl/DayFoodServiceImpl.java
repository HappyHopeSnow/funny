package com.weishu.web.day_food.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.day_food.dao.DayFoodMapper;
import com.weishu.web.day_food.entity.DayFood;
import com.weishu.web.day_food.entity.DayFoodExample;
import com.weishu.web.day_food.service.DayFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午5:47
 */
@Service
public class DayFoodServiceImpl implements DayFoodService {

    @Autowired
    DayFoodMapper dayFoodMapper;

    @Override
    public void save(DayFood dayFood) {
        dayFoodMapper.insert(dayFood);
    }

    @Override
    public void update(DayFood dayFood) {
        dayFoodMapper.updateByPrimaryKeySelective(dayFood);
    }

    @Override
    public DayFood queryById(Long id) {
        return dayFoodMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(DayFood dayFood) {
        dayFood.setUpdateTime(new Date());
        dayFood.setIsDelete(DeleteEnum.DELETE.getCode());

        dayFoodMapper.updateByPrimaryKeySelective(dayFood);
    }

    @Override
    public PageInfo<DayFood> queryList(int pageNo, int pageSize) {

        DayFoodExample example = new DayFoodExample();
        DayFoodExample.Criteria c = example.createCriteria();
        example.setOrderByClause("show_index desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<DayFood> list = dayFoodMapper.selectByExample(example);
        PageInfo<DayFood> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public List<DayFood> queryByDayIndex(Integer dayIndex) {
        DayFoodExample example = new DayFoodExample();
        DayFoodExample.Criteria c = example.createCriteria();
        c.andDayIndexEqualTo(dayIndex);
        return dayFoodMapper.selectByExample(example);
    }

    @Override
    public void recovery(DayFood dayFood) {
        dayFood.setUpdateTime(new Date());
        dayFood.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

        dayFoodMapper.updateByPrimaryKeySelective(dayFood);
    }
}
