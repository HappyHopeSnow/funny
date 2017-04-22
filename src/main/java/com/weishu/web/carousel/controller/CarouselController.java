package com.weishu.web.carousel.controller;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.web.carousel.entity.Carousel;
import com.weishu.web.carousel.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * 轮播图
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "carousel/")
@Controller
public class CarouselController {
    

    @Autowired
    CarouselService carouselService;


    /**
     * 轮播图查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("list")
    public UnifiedResponse getList(@RequestParam(required = false, value = "no", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "size", defaultValue = "10") int pageSize) {
        PageInfo<Carousel> carouselsInfo = carouselService.queryList(pageNo, pageSize);

        UnifiedResponse unifiedResponse = new UnifiedResponse();
        unifiedResponse.setData(carouselsInfo);
        return unifiedResponse;

    }

}
