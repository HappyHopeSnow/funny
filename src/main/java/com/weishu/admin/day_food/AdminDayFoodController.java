package com.weishu.admin.day_food;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.day_food.entity.DayFood;
import com.weishu.web.day_food.service.DayFoodService;
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
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/day_food/")
@Controller
public class AdminDayFoodController {

    private static final String PAGE_PREFIX = "/admin/day_food/";

    @Autowired
    DayFoodService dayFoodService;
    /**
     * 跳转到每日美食list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toDayFoodList() {

        return PAGE_PREFIX + "dayFoodList";
    }

    /**
     * 跳转到每日美食添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddDayFood() {

        return PAGE_PREFIX + "addDayFood";
    }

    /**
     * 跳转到每日美食修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateDayFood(Long id, Model model) {
        final DayFood dayFood = dayFoodService.queryById(id);
        model.addAttribute("dayFood", dayFood);
        return PAGE_PREFIX + "toUpdateDayFood";
    }

    /**
     * 每日美食查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<DayFood> dayFoodsInfo = dayFoodService.queryList(pageNo, pageSize);

        long total = dayFoodsInfo.getTotal();
        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (dayFoodsInfo.getSize() > 0) {
            returnMap.put("rows", dayFoodsInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(DayFood dayFood) {

        Date now = new Date();
        dayFood.setCreateTime(now);
        dayFood.setUpdateTime(now);
        dayFood.setIsDelete((byte) 0);
        //插入数据
        dayFoodService.save(dayFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 每日美食更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(DayFood dayFood) {

        dayFood.setUpdateTime(new Date());

        //更新数据
        dayFoodService.update(dayFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 每日美食删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        DayFood dayFood = dayFoodService.queryById(id);
        if (dayFood == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个每日美食");
        }
        //状态删除数据
        dayFoodService.del(dayFood);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

    /**
     * 每日美食恢复接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("recovery")
    public UnifiedResponse recovery(@RequestParam(value = "id") long id) {

        DayFood dayFood = dayFoodService.queryById(id);
        if (dayFood == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个食物");
        }
        //状态恢复数据
        dayFoodService.recovery(dayFood);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");
        return unifiedResponse;

    }

}
