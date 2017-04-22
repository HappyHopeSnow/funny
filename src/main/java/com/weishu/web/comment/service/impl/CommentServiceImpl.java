package com.weishu.web.comment.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.web.comment.dao.CommentMapper;
import com.weishu.web.comment.entity.Comment;
import com.weishu.web.comment.entity.CommentExample;
import com.weishu.web.comment.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public void save(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void update(Comment comment) {
        commentMapper.updateByPrimaryKeySelective(comment);
    }

    @Override
    public Comment queryById(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Comment user) {
        user.setUpdateTime(new Date());
        user.setIsDelete((byte) 1);

        commentMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public PageInfo<Comment> queryList(int pageNo, int pageSize) {

        CommentExample example = new CommentExample();
        CommentExample.Criteria c = example.createCriteria();
        example.setOrderByClause("create_time desc");

        PageHelper.startPage(pageNo, pageSize);
        List<Comment> list = commentMapper.selectByExample(example);
        PageInfo<Comment> page = new PageInfo<>(list);
        return page;
    }
}
