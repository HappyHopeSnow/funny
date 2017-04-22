package com.weishu.admin.recipes;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.recipes.entity.Recipes;
import com.weishu.web.recipes.service.RecipesService;
import com.weishu.web.recipes_type.entity.RecipesType;
import com.weishu.web.recipes_type.service.RecipesTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/recipes/")
@Controller
public class AdminRecipesController {

    private static final String PAGE_PREFIX = "/admin/recipes/";

    @Autowired
    RecipesService recipesService;

    @Autowired
    RecipesTypeService recipesTypeService;
    /**
     * 跳转到食谱list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toRecipesList() {

        return PAGE_PREFIX + "RecipesList";
    }

    /**
     * 跳转到食谱添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddRecipes(Model model) {
        PageInfo<RecipesType> recipesTypeList = recipesTypeService.queryList(-1, -1);
        model.addAttribute("recipesTypeList", recipesTypeList.getList());
        return PAGE_PREFIX + "addRecipes";
    }

    /**
     * 跳转到食谱修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateRecipes(Long id, Model model) {
        final Recipes recipes = recipesService.queryById(id);
        model.addAttribute("recipes", recipes);
        return PAGE_PREFIX + "toUpdateRecipes";
    }

    /**
     * 食谱查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<Recipes> recipesInfo = recipesService.queryList(pageNo, pageSize);


        long total = recipesInfo.getTotal();
        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (recipesInfo.getSize() > 0) {
            returnMap.put("rows", recipesInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Recipes recipes) {

        Date now = new Date();
        recipes.setCreateTime(now);
        recipes.setUpdateTime(now);
        recipes.setIsDelete((byte) 0);
        //插入数据
        recipesService.save(recipes);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 食谱更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Recipes recipes) {

        recipes.setUpdateTime(new Date());

        //更新数据
        recipesService.update(recipes);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 食谱删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        Recipes user = recipesService.queryById(id);
        if (user == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个食谱");
        }
        //状态删除数据
        recipesService.del(user);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
