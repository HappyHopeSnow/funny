package com.weishu.web.recipes_type.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.recipes_type.dao.RecipesTypeMapper;
import com.weishu.web.recipes_type.entity.RecipesType;
import com.weishu.web.recipes_type.entity.RecipesTypeExample;
import com.weishu.web.recipes_type.service.RecipesTypeService;
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
public class RecipesTypeServiceImpl implements RecipesTypeService {

    @Autowired
    RecipesTypeMapper recipesTypeMapper;

    @Override
    public void save(RecipesType recipesType) {
        recipesTypeMapper.insert(recipesType);
    }

    @Override
    public void update(RecipesType recipesType) {
        recipesTypeMapper.updateByPrimaryKeySelective(recipesType);
    }

    @Override
    public RecipesType queryById(Long id) {
        return recipesTypeMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(RecipesType recipesType) {
        recipesType.setUpdateTime(new Date());
        recipesType.setIsDelete(DeleteEnum.DELETE.getCode());

        recipesTypeMapper.updateByPrimaryKeySelective(recipesType);
    }

    @Override
    public PageInfo<RecipesType> queryList(int pageNo, int pageSize) {

        RecipesTypeExample example = new RecipesTypeExample();
        RecipesTypeExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        if (pageNo != -1 && pageSize != -1) {
            PageHelper.startPage(pageNo, pageSize);
        }

        List<RecipesType> list = recipesTypeMapper.selectByExample(example);
        PageInfo<RecipesType> page = new PageInfo<>(list);
        return page;
    }
}
