package com.weishu.web.step.dao;

import com.weishu.web.step.entity.Step;
import com.weishu.web.step.entity.StepExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StepMapper {
    int deleteByExample(StepExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Step record);

    int insertSelective(Step record);

    List<Step> selectByExample(StepExample example);

    Step selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Step record, @Param("example") StepExample example);

    int updateByExample(@Param("record") Step record, @Param("example") StepExample example);

    int updateByPrimaryKeySelective(Step record);

    int updateByPrimaryKey(Step record);
}