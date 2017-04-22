package com.weishu.admin.recommend_food;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.recommend_food.entity.RecommendFood;
import com.weishu.web.recommend_food.service.RecommendFoodService;
import com.weishu.web.user.entity.User;
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
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/recommend_food/")
@Controller
public class AdminRecommendFoodController {

    private static final String PAGE_PREFIX = "/admin/recommend_food/";

    @Autowired
    RecommendFoodService recommendFoodService;
    /**
     * 跳转到美食推荐list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toRecommendFoodList() {

        return PAGE_PREFIX + "recommendFoodList";
    }

    /**
     * 跳转到美食推荐添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddRecommendFood() {

        return PAGE_PREFIX + "addRecommendFood";
    }

    /**
     * 跳转到美食推荐修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateRecommendFood(Long id, Model model) {
        final RecommendFood recommendFood = recommendFoodService.queryById(id);
        model.addAttribute("recommendFood", recommendFood);
        return PAGE_PREFIX + "toUpdateRecommendFood";
    }

    /**
     * 美食推荐查询列表接口
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "status", defaultValue = "-1") Integer status,
                                   @RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<RecommendFood> recommendFoodsInfo = recommendFoodService.queryList(pageNo, pageSize);

        long total = recommendFoodsInfo.getTotal();
        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (recommendFoodsInfo.getSize() > 0) {
            returnMap.put("rows", recommendFoodsInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(RecommendFood recommendFood) {

        Date now = new Date();
        recommendFood.setCreateTime(now);
        recommendFood.setUpdateTime(now);
        recommendFood.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        //插入数据
        recommendFoodService.save(recommendFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 美食推荐更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(RecommendFood recommendFood) {

        recommendFood.setUpdateTime(new Date());

        //更新数据
        recommendFoodService.update(recommendFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 美食推荐删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(value = "id") long id) {

        RecommendFood recommendFood = recommendFoodService.queryById(id);
        if (recommendFood == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个美食推荐");
        }
        //状态删除数据
        recommendFoodService.del(recommendFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");
        return unifiedResponse;
    }

}
