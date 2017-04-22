package com.weishu.web.day_food.controller;

import com.github.pagehelper.PageInfo;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.day_food.entity.DayFood;
import com.weishu.web.day_food.service.DayFoodService;
import com.weishu.web.recommend_food.entity.RecommendFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 每日美食
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "day/")
@Controller
public class DayFoodController {
    

    @Autowired
    DayFoodService dayFoodService;


    /**
     * 查询
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public UnifiedResponse getList(@RequestParam(required = false, value = "no", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "size", defaultValue = "3") int pageSize) {
        PageInfo<DayFood> dayFoodInfo = dayFoodService.queryList(pageNo, pageSize);

        UnifiedResponse unifiedResponse = new UnifiedResponse();
        unifiedResponse.setData(dayFoodInfo);
        return unifiedResponse;

    }

}
