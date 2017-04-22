package com.weishu.admin.food;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.food.entity.Food;
import com.weishu.web.food.service.FoodService;
import com.weishu.web.recipes.entity.Recipes;
import com.weishu.web.recipes_type.entity.RecipesType;
import com.weishu.web.recipes_type.service.RecipesTypeService;
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
import java.util.List;

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/food/")
@Controller
public class AdminFoodController {

    private static final String PAGE_PREFIX = "/admin/food/";

    @Autowired
    FoodService foodService;

    @Autowired
    RecipesTypeService recipesTypeService;

    /**
     * 跳转到食物list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toFoodList() {

        return PAGE_PREFIX + "foodList";
    }

    /**
     * 跳转到食物添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddFood(Model model) {
        PageInfo<RecipesType> recipesTypeList = recipesTypeService.queryList(-1, -1);
        model.addAttribute("recipesTypeList", recipesTypeList.getList());

        return PAGE_PREFIX + "addFood";
    }

    /**
     * 跳转到食物修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateFood(Long id, Model model) {
        final Food food = foodService.queryById(id);
        model.addAttribute("food", food);
        return PAGE_PREFIX + "toUpdateFood";
    }

    /**
     * 食物查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<Food> foodsInfo = foodService.queryList(pageNo, pageSize);

        long total = foodsInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (foodsInfo.getSize() > 0) {
            returnMap.put("rows", foodsInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Food food) {

        Date now = new Date();
        food.setCreateTime(now);
        food.setUpdateTime(now);
        food.setIsDelete((byte) 0);
        //插入数据
        foodService.save(food);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 食物更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Food food) {

        food.setUpdateTime(new Date());

        //更新数据
        foodService.update(food);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 食物删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        Food food = foodService.queryById(id);
        if (food == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个食物");
        }
        //状态删除数据
        foodService.del(food);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

    /**
     * 食物恢复接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("recovery")
    public UnifiedResponse recovery(@RequestParam(required = true, value = "id") Long id,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        Food food = foodService.queryById(id);
        if (food == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个食物");
        }
        //状态恢复数据
        foodService.recovery(food);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
