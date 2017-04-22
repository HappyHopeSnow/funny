package com.weishu.web.recipes.dao;

import com.weishu.web.recipes.entity.Recipes;
import com.weishu.web.recipes.entity.RecipesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecipesMapper {
    int deleteByExample(RecipesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Recipes record);

    int insertSelective(Recipes record);

    List<Recipes> selectByExample(RecipesExample example);

    Recipes selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Recipes record, @Param("example") RecipesExample example);

    int updateByExample(@Param("record") Recipes record, @Param("example") RecipesExample example);

    int updateByPrimaryKeySelective(Recipes record);

    int updateByPrimaryKey(Recipes record);
}