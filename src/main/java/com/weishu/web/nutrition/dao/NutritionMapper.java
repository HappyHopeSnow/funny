package com.weishu.web.nutrition.dao;

import com.weishu.web.nutrition.entity.Nutrition;
import com.weishu.web.nutrition.entity.NutritionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NutritionMapper {
    int deleteByExample(NutritionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Nutrition record);

    int insertSelective(Nutrition record);

    List<Nutrition> selectByExample(NutritionExample example);

    Nutrition selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Nutrition record, @Param("example") NutritionExample example);

    int updateByExample(@Param("record") Nutrition record, @Param("example") NutritionExample example);

    int updateByPrimaryKeySelective(Nutrition record);

    int updateByPrimaryKey(Nutrition record);
}