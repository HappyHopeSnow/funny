package com.weishu.admin.nutrition;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.nutrition.entity.Nutrition;
import com.weishu.web.nutrition.service.NutritionService;
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

/**
 * 
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/nutrition/")
@Controller
public class AdminNutritionController {

    private static final String PAGE_PREFIX = "/admin/nutrition/";

    @Autowired
    NutritionService nutritionService;

    @Autowired
    RecipesTypeService recipesTypeService;

    /**
     * 跳转到营养list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toNutritionList(@RequestParam(value = "foodId") long foodId,
                                  @RequestParam(value = "foodName") String foodName,
                                  Model model) {
        model.addAttribute("foodId", foodId);
        model.addAttribute("foodName", foodName);
        return PAGE_PREFIX + "nutritionList";
    }

    /**
     * 跳转到营养添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddNutrition(@RequestParam(value = "foodId") long foodId,
                                 @RequestParam(value = "foodName") String foodName,
                                 Model model) {
        model.addAttribute("foodId", foodId);
        model.addAttribute("foodName", foodName);
        return PAGE_PREFIX + "addNutrition";
    }

    /**
     * 跳转到营养修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateNutrition(@RequestParam(value = "id")long id,
                                    @RequestParam(value = "foodId") long foodId,
                                    @RequestParam(value = "foodName") String foodName,
                                    Model model) {
        final Nutrition nutrition = nutritionService.queryById(id);
        model.addAttribute("nutrition", nutrition);
        model.addAttribute("foodId", foodId);
        model.addAttribute("foodName", foodName);
        return PAGE_PREFIX + "toUpdateNutrition";
    }

    /**
     * 营养查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(value = "foodId") long foodId,
                                           @RequestParam(required = false, value = "no", defaultValue = "1") int pageNo,
                                           @RequestParam(required = false, value = "size", defaultValue = "10") int pageSize) {
        PageInfo<Nutrition> nutritionPageInfo = nutritionService.queryList(foodId, pageNo, pageSize);

        long total = nutritionPageInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (nutritionPageInfo.getSize() > 0) {
            returnMap.put("rows", nutritionPageInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Nutrition nutrition) {

        Date now = new Date();
        nutrition.setCreateTime(now);
        nutrition.setUpdateTime(now);
        nutrition.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        //插入数据
        nutritionService.save(nutrition);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 营养更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Nutrition nutrition) {

        nutrition.setUpdateTime(new Date());

        //更新数据
        nutritionService.update(nutrition);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 营养删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(value = "id") long id) {

        Nutrition nutrition = nutritionService.queryById(id);
        if (nutrition == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个营养");
        }
        //状态删除数据
        nutritionService.del(nutrition);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

    /**
     * 营养恢复接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("recovery")
    public UnifiedResponse recovery(@RequestParam(value = "id") long id) {

        Nutrition nutrition = nutritionService.queryById(id);
        if (nutrition == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个营养");
        }
        //状态恢复数据
        nutritionService.recovery(nutrition);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
