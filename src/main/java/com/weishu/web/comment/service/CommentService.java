package com.weishu.web.comment.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.comment.entity.Comment;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface CommentService {
    void save(Comment comment);

    void update(Comment comment);

    Comment queryById(Long id);

    void del(Comment user);

    PageInfo<Comment> queryList(int pageNo, int pageSize);
}
