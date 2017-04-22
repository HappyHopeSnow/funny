package com.weishu.web.file.dao;

import com.weishu.web.file.entity.File;
import com.weishu.web.file.entity.FileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {
    int deleteByExample(FileExample example);

    int deleteByPrimaryKey(Long id);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileExample example);

    File selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileExample example);

    int updateByExample(@Param("record") File record, @Param("example") FileExample example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}