package com.weishu.web.food.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.food.dao.FoodMapper;
import com.weishu.web.food.entity.Food;
import com.weishu.web.food.entity.FoodExample;
import com.weishu.web.food.service.FoodService;
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
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodMapper foodMapper;

    @Override
    public void save(Food food) {
        foodMapper.insert(food);
    }

    @Override
    public void update(Food food) {
        foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public Food queryById(Long id) {
        return foodMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Food food) {
        food.setUpdateTime(new Date());
        food.setIsDelete(DeleteEnum.DELETE.getCode());

        foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public PageInfo<Food> queryList(int pageNo, int pageSize) {

        FoodExample example = new FoodExample();
        FoodExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<Food> list = foodMapper.selectByExample(example);
        PageInfo<Food> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void recovery(Food food) {
        food.setUpdateTime(new Date());
        food.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

        foodMapper.updateByPrimaryKeySelective(food);
    }
}
