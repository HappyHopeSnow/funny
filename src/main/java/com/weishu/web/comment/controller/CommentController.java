package com.weishu.web.comment.controller;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.comment.entity.Comment;
import com.weishu.web.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "comment/")
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;

    /**
     * 吐槽查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<Comment> commentsInfo = commentService.queryList(pageNo, pageSize);

        long total = commentsInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (commentsInfo.getSize() > 0) {
            returnMap.put("rows", commentsInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Comment comment) {

        Date now = new Date();

        comment.setCreateTime(now);
        comment.setUpdateTime(now);
        comment.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        //插入数据
        commentService.save(comment);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 吐槽更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Comment comment) {
        comment.setUpdateTime(new Date());

        //更新数据
        commentService.update(comment);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 吐槽删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(value = "id") long id) {

        Comment comment = commentService.queryById(id);
        if (comment == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个吐槽");
        }
        //状态删除数据
        commentService.del(comment);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");
        return unifiedResponse;

    }

}
