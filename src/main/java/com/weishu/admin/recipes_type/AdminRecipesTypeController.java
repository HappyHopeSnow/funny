package com.weishu.admin.recipes_type;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
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

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/recipes_type/")
@Controller
public class AdminRecipesTypeController {

    private static final String PAGE_PREFIX = "/admin/recipes_type/";


    @Autowired
    RecipesTypeService recipesTypeService;
    /**
     * 跳转到食谱分类list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toRecipesTypeList() {

        return PAGE_PREFIX + "recipesTypeList";
    }

    /**
     * 跳转到食谱分类添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddRecipesType() {

        return PAGE_PREFIX + "addRecipesType";
    }

    /**
     * 跳转到食谱分类修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateRecipesType(Long id, Model model) {
        final RecipesType recipesType = recipesTypeService.queryById(id);
        model.addAttribute("recipesType", recipesType);
        return PAGE_PREFIX + "toUpdateRecipesType";
    }

    /**
     * 食谱分类查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<RecipesType> recipesTypePageInfo = recipesTypeService.queryList(pageNo, pageSize);

        long total = recipesTypePageInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (recipesTypePageInfo.getSize() > 0) {
            returnMap.put("rows", recipesTypePageInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(RecipesType recipes) {

        Date now = new Date();
        recipes.setCreateTime(now);
        recipes.setUpdateTime(now);
        recipes.setIsDelete((byte) 0);
        //插入数据
        recipesTypeService.save(recipes);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 食谱分类更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(RecipesType recipes) {

        recipes.setUpdateTime(new Date());

        //更新数据
        recipesTypeService.update(recipes);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 食谱分类删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        RecipesType recipesType = recipesTypeService.queryById(id);
        if (recipesType == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个食谱分类");
        }
        //状态删除数据
        recipesTypeService.del(recipesType);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
