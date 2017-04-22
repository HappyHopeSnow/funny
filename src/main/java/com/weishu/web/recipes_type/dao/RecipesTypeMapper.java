package com.weishu.web.recipes_type.dao;

import com.weishu.web.recipes_type.entity.RecipesType;
import com.weishu.web.recipes_type.entity.RecipesTypeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecipesTypeMapper {
    int deleteByExample(RecipesTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RecipesType record);

    int insertSelective(RecipesType record);

    List<RecipesType> selectByExample(RecipesTypeExample example);

    RecipesType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RecipesType record, @Param("example") RecipesTypeExample example);

    int updateByExample(@Param("record") RecipesType record, @Param("example") RecipesTypeExample example);

    int updateByPrimaryKeySelective(RecipesType record);

    int updateByPrimaryKey(RecipesType record);
}