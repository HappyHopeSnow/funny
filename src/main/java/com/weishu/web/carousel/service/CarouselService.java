package com.weishu.web.carousel.service;

import com.github.pagehelper.PageInfo;
import com.weishu.web.carousel.entity.Carousel;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午12:43
 */
public interface CarouselService {

    void save(Carousel carousel);

    void update(Carousel carousel);

    Carousel queryById(Long id);

    void del(Carousel carousel);

    PageInfo<Carousel> queryList(int pageNo, int pageSize);

    void recovery(Carousel carousel);
}
