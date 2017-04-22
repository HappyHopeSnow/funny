package com.weishu.web.step.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.step.entity.Step;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface StepService {
    void save(Step step);

    void update(Step step);

    Step queryById(Long id);

    void del(Step step);

    PageInfo<Step> queryList(long recipesId, int pageNo, int pageSize);

    void recovery(Step step);
}
