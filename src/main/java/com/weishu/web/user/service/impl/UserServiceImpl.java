package com.weishu.web.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.user.dao.UserMapper;
import com.weishu.web.user.entity.User;
import com.weishu.web.user.entity.UserExample;
import com.weishu.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/3/30 下午9:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(User user) {
        user.setUpdateTime(new Date());
        user.setIsDelete(DeleteEnum.DELETE.getCode());

        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public PageInfo<User> queryList(int pageNo, int pageSize) {

        UserExample example = new UserExample();
        UserExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        PageHelper.startPage(pageNo, pageSize);
        List<User> list = userMapper.selectByExample(example);
        PageInfo<User> page = new PageInfo<>(list);
        return page;
    }
}
