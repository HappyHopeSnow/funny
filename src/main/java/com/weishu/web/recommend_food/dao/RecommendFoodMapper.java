package com.weishu.web.recommend_food.dao;

import com.weishu.web.recommend_food.entity.RecommendFood;
import com.weishu.web.recommend_food.entity.RecommendFoodExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendFoodMapper {
    int deleteByExample(RecommendFoodExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RecommendFood record);

    int insertSelective(RecommendFood record);

    List<RecommendFood> selectByExample(RecommendFoodExample example);

    RecommendFood selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RecommendFood record, @Param("example") RecommendFoodExample example);

    int updateByExample(@Param("record") RecommendFood record, @Param("example") RecommendFoodExample example);

    int updateByPrimaryKeySelective(RecommendFood record);

    int updateByPrimaryKey(RecommendFood record);
}