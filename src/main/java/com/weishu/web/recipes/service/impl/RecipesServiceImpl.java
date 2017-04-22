package com.weishu.web.recipes.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.util.DateUtils;
import com.weishu.util.StringUtils;
import com.weishu.web.day_food.entity.DayFood;
import com.weishu.web.day_food.service.DayFoodService;
import com.weishu.web.recipes.dao.RecipesMapper;
import com.weishu.web.recipes.entity.Recipes;
import com.weishu.web.recipes.entity.RecipesExample;
import com.weishu.web.recipes.service.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午5:47
 */
@Service
public class RecipesServiceImpl implements RecipesService {

    @Autowired
    RecipesMapper recipesMapper;

    @Autowired
    DayFoodService dayFoodService;

    @Override
    public void save(Recipes recipes) {

        recipesMapper.insert(recipes);
        synchronizeAddDayFood(recipes);
    }

    /**
     * 同步新增今日数据
     * @param recipes
     */
    private void synchronizeAddDayFood(Recipes recipes) {

        Date now = new Date();
        //查看当前时间定义的20170101
        String todayStr = DateUtils.getDate(now);

        //查看是否有当天的日期
        List<DayFood> todayFoodList = dayFoodService.queryByDayIndex(Integer.valueOf(todayStr));

        DayFood dayFood;
        if (todayFoodList != null && todayFoodList.size() > 0) {
            dayFood = todayFoodList.get(0);

            //新增更新这个数组
            dayFood.setUpdateTime(now);
            dayFood.setRecipesIdList(dayFood.getRecipesIdList() + "," + recipes.getId());
            dayFood.setPids(dayFood.getPids() + "," + recipes.getPid());
            dayFoodService.update(dayFood);
        }else {
            //如果是今天的新数据,就插入
            dayFood = new DayFood();
            String todayChina = DateUtils.getDateWithChina();
            dayFood.setDayIndex(Integer.valueOf(todayStr));
            dayFood.setTitleDate(todayChina);
            dayFood.setTitleWeek(DateUtils.getWeekChina(now));
            dayFood.setRecipesIdList(String.valueOf(recipes.getId()));
            dayFood.setPids(String.valueOf(recipes.getPid()));

            dayFood.setCreateTime(now);
            dayFood.setUpdateTime(now);
            dayFood.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

            dayFoodService.save(dayFood);
        }

    }

    /**
     * 同步更新对应的图片
     * @param recipes
     */
    private void synchronizeUpdateDayFood(Recipes recipes) {

        recipes = recipesMapper.selectByPrimaryKey(recipes.getId());
        Date date = recipes.getCreateTime();
        //查看当前时间定义的20170101
        String todayStr = DateUtils.getDate(date);
        List<DayFood> todayFoodList = dayFoodService.queryByDayIndex(Integer.valueOf(todayStr));

        DayFood dayFood;
        if (todayFoodList != null && todayFoodList.size() > 0) {
            dayFood = todayFoodList.get(0);

            //更新图图片数组
            String pidList = dayFood.getPids();
            String[] pids = pidList.split(",");

            String recipesIdList = dayFood.getRecipesIdList();
            String[] recipesIds = recipesIdList.split(",");

            for(int i = 0; i < recipesIds.length; i++) {
                if (String.valueOf(recipes.getId()).equals(recipesIds[i])) {
                    pids[i] = String.valueOf(recipes.getPid());
                    break;
                }
            }

            dayFood.setUpdateTime(date);
            dayFood.setPids(StringUtils.join(pids, ","));
            dayFoodService.update(dayFood);
        }
    }

    /**
     * 同步删除对应的食谱
     * @param recipes
     */
    private void synchronizeDeleteDayFood(Recipes recipes) {
        recipes = recipesMapper.selectByPrimaryKey(recipes.getId());
        Date date = recipes.getCreateTime();
        //查看当前时间定义的20170101
        String todayStr = DateUtils.getDate(date);
        List<DayFood> todayFoodList = dayFoodService.queryByDayIndex(Integer.valueOf(todayStr));

        DayFood dayFood;
        if (todayFoodList != null && todayFoodList.size() > 0) {
            dayFood = todayFoodList.get(0);

            //删除图片数组
            String pidList = dayFood.getPids();
            String[] pids = pidList.split(",");
            List<String> pidArrayList = new ArrayList(Arrays.asList(pids));

            String recipesIdList = dayFood.getRecipesIdList();
            String[] recipesIds = recipesIdList.split(",");
            List<String> recipesIdArrayList = new ArrayList(Arrays.asList(recipesIds));

            int removeIndex = recipesIdArrayList.size() - 1;
            for(int i = 0; i < recipesIdArrayList.size(); i++) {
                if (String.valueOf(recipes.getId()).equals(recipesIdArrayList.get(i))) {
                    removeIndex = i;
                    break;
                }
            }

            //移除元素
            pidArrayList.remove(removeIndex);
            recipesIdArrayList.remove(removeIndex);

            dayFood.setUpdateTime(date);
            dayFood.setRecipesIdList(StringUtils.join(recipesIdArrayList, ","));
            dayFood.setPids(StringUtils.join(pidArrayList, ","));
            dayFoodService.update(dayFood);
        }
    }

    @Override
    public void update(Recipes recipes) {
        recipesMapper.updateByPrimaryKeySelective(recipes);
        synchronizeUpdateDayFood(recipes);
    }

    @Override
    public Recipes queryById(Long id) {
        return recipesMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Recipes recipes) {
        recipes.setUpdateTime(new Date());
        recipes.setIsDelete(DeleteEnum.DELETE.getCode());

        recipesMapper.updateByPrimaryKeySelective(recipes);

        synchronizeDeleteDayFood(recipes);
    }

    @Override
    public PageInfo<Recipes> queryList(int pageNo, int pageSize) {

        RecipesExample example = new RecipesExample();
        RecipesExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<Recipes> list = recipesMapper.selectByExample(example);
        PageInfo<Recipes> page = new PageInfo<>(list);
        return page;
    }
}
