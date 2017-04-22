package com.weishu.web.recommend_food.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.recommend_food.dao.RecommendFoodMapper;
import com.weishu.web.recommend_food.entity.RecommendFood;
import com.weishu.web.recommend_food.entity.RecommendFoodExample;
import com.weishu.web.recommend_food.service.RecommendFoodService;
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
public class RecommendFoodServiceImpl implements RecommendFoodService {

    @Autowired
    RecommendFoodMapper recommendFoodMapper;

    @Override
    public void save(RecommendFood recommendFood) {
        recommendFoodMapper.insert(recommendFood);
    }

    @Override
    public void update(RecommendFood recommendFood) {
        recommendFoodMapper.updateByPrimaryKeySelective(recommendFood);
    }

    @Override
    public RecommendFood queryById(Long id) {
        return recommendFoodMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(RecommendFood recommendFood) {
        recommendFood.setUpdateTime(new Date());
        recommendFood.setIsDelete(DeleteEnum.DELETE.getCode());

        recommendFoodMapper.updateByPrimaryKeySelective(recommendFood);
    }

    @Override
    public PageInfo<RecommendFood> queryList(int pageNo, int pageSize) {

        RecommendFoodExample example = new RecommendFoodExample();
        RecommendFoodExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<RecommendFood> list = recommendFoodMapper.selectByExample(example);
        PageInfo<RecommendFood> page = new PageInfo<>(list);
        return page;
    }
}
