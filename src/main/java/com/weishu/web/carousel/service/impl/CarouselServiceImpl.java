package com.weishu.web.carousel.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.carousel.dao.CarouselMapper;
import com.weishu.web.carousel.entity.Carousel;
import com.weishu.web.carousel.entity.CarouselExample;
import com.weishu.web.carousel.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/4/4 下午5:47
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public void save(Carousel user) {
        carouselMapper.insert(user);
    }

    @Override
    public void update(Carousel user) {
        carouselMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Carousel queryById(Long id) {
        return carouselMapper.selectByPrimaryKey(id);
    }


    @Override
    public void del(Carousel user) {
        user.setUpdateTime(new Date());
        user.setIsDelete((byte) 1);

        carouselMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void recovery(Carousel user) {
        user.setUpdateTime(new Date());
        user.setIsDelete(DeleteEnum.NOT_DELETE.getCode());

        carouselMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public PageInfo<Carousel> queryList(int pageNo, int pageSize) {

        CarouselExample example = new CarouselExample();
        CarouselExample.Criteria c = example.createCriteria();
        c.andIsDeleteEqualTo(DeleteEnum.NOT_DELETE.getCode());

        example.setOrderByClause("create_time desc");

        PageHelper.startPage(pageNo, pageSize);
        List<Carousel> list = carouselMapper.selectByExample(example);
        PageInfo<Carousel> page = new PageInfo<>(list);
        return page;
    }
}
