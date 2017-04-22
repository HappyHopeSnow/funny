package com.weishu.admin.carousel;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.carousel.entity.Carousel;
import com.weishu.web.carousel.service.CarouselService;
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
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/carousel/")
@Controller
public class AdminCarouselController {
    
    private static final String PAGE_PREFIX = "/admin/carousel/";


    @Autowired
    CarouselService carouselService;
    /**
     * 跳转到轮播图list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toCarouselList() {

        return PAGE_PREFIX + "carouselList";
    }

    /**
     * 跳转到轮播图添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddCarousel() {

        return PAGE_PREFIX + "addCarousel";
    }

    /**
     * 跳转到轮播图修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateCarousel(Long id, Model model) {
        final Carousel carousel = carouselService.queryById(id);
        model.addAttribute("carousel", carousel);
        return PAGE_PREFIX + "toUpdateCarousel";
    }

    /**
     * 轮播图查询列表接口
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "status", defaultValue = "-1") Integer status,
                                   @RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<Carousel> carouselsInfo = carouselService.queryList(pageNo, pageSize);

        long total = carouselsInfo.getTotal();
        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (carouselsInfo.getSize() > 0) {
            returnMap.put("rows", carouselsInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(Carousel carousel) {

        Date now = new Date();
        carousel.setCreateTime(now);
        carousel.setUpdateTime(now);
        carousel.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        carouselService.save(carousel);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 轮播图更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(Carousel carousel) {

        carousel.setUpdateTime(new Date());

        //更新数据
        carouselService.update(carousel);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 轮播图删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(required = true, value = "id") Long id,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {

        Carousel carousel = carouselService.queryById(id);
        if (carousel == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个轮播图");
        }
        //状态删除数据
        carouselService.del(carousel);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

    /**
     * 轮播图删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("recovery")
    public UnifiedResponse recovery(@RequestParam(required = true, value = "id") Long id,
                               HttpServletRequest request,
                               HttpServletResponse response) {

        Carousel carousel = carouselService.queryById(id);
        if (carousel == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个轮播图");
        }
        //恢复数据
        carouselService.recovery(carousel);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }
}
