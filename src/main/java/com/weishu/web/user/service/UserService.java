package com.weishu.web.user.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.user.entity.User;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/3/30 下午9:58
 */
public interface UserService {

    void save(User user);

    void update(User user);

    User queryById(Long staffId);

    void del(User user);

    PageInfo<User> queryList(int pageNo, int pageSize);
}
