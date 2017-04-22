package com.weishu.web.food.dao;

import com.weishu.web.food.entity.Food;
import com.weishu.web.food.entity.FoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {
    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Food record);

    int insertSelective(Food record);

    List<Food> selectByExample(FoodExample example);

    Food selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(Food record);

    int updateByPrimaryKey(Food record);
}