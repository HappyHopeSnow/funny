package com.weishu.admin.step;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.recipes_type.service.RecipesTypeService;
import com.weishu.web.step.entity.Step;
import com.weishu.web.step.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

/**
 * 
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/step/")
@Controller
public class AdminStepController {

    private static final String PAGE_PREFIX = "/admin/step/";

    @Autowired
    StepService stepService;

    @Autowired
    RecipesTypeService recipesTypeService;

    /**
     * 跳转到步骤list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toStepList(@RequestParam(value = "recipesId") long recipesId,
                                  @RequestParam(value = "recipesName") String recipesName,
                                  Model model) {
        model.addAttribute("recipesId", recipesId);
        model.addAttribute("recipesName", recipesName);
        return PAGE_PREFIX + "stepList";
    }

    /**
     * 跳转到步骤添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddStep(@RequestParam(value = "recipesId") long recipesId,
                                 @RequestParam(value = "recipesName") String recipesName,
                                 Model model) {
        model.addAttribute("recipesId", recipesId);
        model.addAttribute("recipesName", recipesName);
        return PAGE_PREFIX + "addStep";
    }

    /**
     * 跳转到步骤修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateStep(@RequestParam(value = "id")long id,
                                    @RequestParam(value = "recipesId") long recipesId,
                                    @RequestParam(value = "recipesName") String recipesName,
                                    Model model) {
        final Step step = stepService.queryById(id);
        model.addAttribute("step", step);
        model.addAttribute("recipesId", recipesId);
        model.addAttribute("recipesName", recipesName);
        return PAGE_PREFIX + "toUpdatestep";
    }

    /**
     * 步骤查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(value = "recipesId") long recipesId,
                                           @RequestParam(required = false, value = "no", defaultValue = "1") int pageNo,
                                           @RequestParam(required = false, value = "size", defaultValue = "10") int pageSize) {
        PageInfo<Step> stepPageInfo = stepService.queryList(recipesId, pageNo, pageSize);

        long total = stepPageInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (stepPageInfo.getSize() > 0) {
            returnMap.put("rows", stepPageInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Step step) {

        Date now = new Date();
        step.setCreateTime(now);
        step.setUpdateTime(now);
        step.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        //插入数据
        stepService.save(step);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 步骤更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Step step) {

        step.setUpdateTime(new Date());

        //更新数据
        stepService.update(step);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 步骤删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(value = "id") long id) {

        Step step = stepService.queryById(id);
        if (step == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个步骤");
        }
        //状态删除数据
        stepService.del(step);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

    /**
     * 步骤恢复接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("recovery")
    public UnifiedResponse recovery(@RequestParam(value = "id") long id) {

        Step step = stepService.queryById(id);
        if (step == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个步骤");
        }
        //状态恢复数据
        stepService.recovery(step);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
