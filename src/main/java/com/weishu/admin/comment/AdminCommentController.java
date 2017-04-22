package com.weishu.admin.comment;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.comment.entity.Comment;
import com.weishu.web.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/comment/")
@Controller
public class AdminCommentController {

    private static final String PAGE_PREFIX = "/admin/comment/";


    @Autowired
    CommentService commentService;
    /**
     * 跳转到评论list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toCommentList() {

        return PAGE_PREFIX + "commentList";
    }

    /**
     * 跳转到评论添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddComment() {

        return PAGE_PREFIX + "addComment";
    }

    /**
     * 跳转到评论修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateComment(Long id, Model model) {
        final Comment comment = commentService.queryById(id);
        model.addAttribute("comment", comment);
        return PAGE_PREFIX + "toUpdateComment";
    }

    /**
     * 评论查询列表接口
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "status", defaultValue = "-1") Integer status,
                                   @RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
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
        comment.setIsDelete((byte) 0);
        //插入数据
        commentService.save(comment);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 评论更新接口
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
     * 评论删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        Comment comment = commentService.queryById(id);
        if (comment == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个评论");
        }
        //状态删除数据
        commentService.del(comment);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
