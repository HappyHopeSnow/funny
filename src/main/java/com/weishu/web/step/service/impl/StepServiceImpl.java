package com.weishu.web.step.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.step.dao.StepMapper;
import com.weishu.web.step.entity.Step;
import com.weishu.web.step.entity.StepExample;
import com.weishu.web.step.service.StepService;
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
public class StepServiceImpl implements StepService {

    @Autowired
    StepMapper stepMapper;

    @Override
    public void save(Step step) {
        stepMapper.insert(step);
    }

    @Override
    public void update(Step step) {
        stepMapper.updateByPrimaryKeySelective(step);
    }

    @Override
    public Step queryById(Long id) {
        return stepMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Step step) {
        step.setUpdateTime(new Date());
        step.setIsDelete(DeleteEnum.DELETE.getCode());

        stepMapper.updateByPrimaryKeySelective(step);
    }

    @Override
    public PageInfo<Step> queryList(long recipesId, int pageNo, int pageSize) {

        StepExample example = new StepExample();
        StepExample.Criteria c = example.createCriteria();
        example.setOrderByClause("show_index desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());
        c.andRecipesIdEqualTo(recipesId);

        PageHelper.startPage(pageNo, pageSize);
        List<Step> list = stepMapper.selectByExample(example);
        PageInfo<Step> page = new PageInfo<>(list);
        return page;
    }

    @Override
    public void recovery(Step step) {
        step.setUpdateTime(new Date());
        step.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

        stepMapper.updateByPrimaryKeySelective(step);
    }
}
