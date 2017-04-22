package com.weishu.web.recommend_food.controller;

import com.github.pagehelper.PageInfo;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.recommend_food.entity.RecommendFood;
import com.weishu.web.recommend_food.service.RecommendFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 美食推荐
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "recommend/")
@Controller
public class RecommendFoodController {
    

    @Autowired
    RecommendFoodService recommendFoodService;


    /**
     * 列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public UnifiedResponse getList(@RequestParam(required = false, value = "no", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "size", defaultValue = "10") int pageSize) {
        PageInfo<RecommendFood> recommendFoodInfo = recommendFoodService.queryList(pageNo, pageSize);

        UnifiedResponse unifiedResponse = new UnifiedResponse();
        unifiedResponse.setData(recommendFoodInfo);
        return unifiedResponse;

    }

}
