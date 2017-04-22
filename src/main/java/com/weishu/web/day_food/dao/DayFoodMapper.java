package com.weishu.web.day_food.dao;

import com.weishu.web.day_food.entity.DayFood;
import com.weishu.web.day_food.entity.DayFoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DayFoodMapper {
    int deleteByExample(DayFoodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DayFood record);

    int insertSelective(DayFood record);

    List<DayFood> selectByExample(DayFoodExample example);

    DayFood selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DayFood record, @Param("example") DayFoodExample example);

    int updateByExample(@Param("record") DayFood record, @Param("example") DayFoodExample example);

    int updateByPrimaryKeySelective(DayFood record);

    int updateByPrimaryKey(DayFood record);
}