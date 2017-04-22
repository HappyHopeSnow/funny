package com.weishu.web.nutrition.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.nutrition.dao.NutritionMapper;
import com.weishu.web.nutrition.entity.Nutrition;
import com.weishu.web.nutrition.entity.NutritionExample;
import com.weishu.web.nutrition.service.NutritionService;
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
public class NutritionServiceImpl implements NutritionService {

    @Autowired
    NutritionMapper nutritionMapper;

    @Override
    public void save(Nutrition nutrition) {
        nutritionMapper.insert(nutrition);
    }

    @Override
    public void update(Nutrition foodNutrition) {
        nutritionMapper.updateByPrimaryKeySelective(foodNutrition);
    }

    @Override
    public Nutrition queryById(Long id) {
        return nutritionMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Nutrition nutrition) {
        nutrition.setUpdateTime(new Date());
        nutrition.setIsDelete(DeleteEnum.DELETE.getCode());

        nutritionMapper.updateByPrimaryKeySelective(nutrition);
    }

    @Override
    public PageInfo<Nutrition> queryList(long foodId, int pageNo, int pageSize) {

        NutritionExample example = new NutritionExample();
        NutritionExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andFoodIdEqualTo(foodId);
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<Nutrition> list = nutritionMapper.selectByExample(example);
        PageInfo<Nutrition> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void recovery(Nutrition nutrition) {
        nutrition.setUpdateTime(new Date());
        nutrition.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

        nutritionMapper.updateByPrimaryKeySelective(nutrition);
    }
}
