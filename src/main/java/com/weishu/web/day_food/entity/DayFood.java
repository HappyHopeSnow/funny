package com.weishu.web.day_food.entity;

import java.util.Date;

public class DayFood {
    private Long id;

    private Integer dayIndex;

    private String titleDate;

    private String titleWeek;

    private String recipesIdList;

    private String pids;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDayIndex() {
        return dayIndex;
    }

    public void setDayIndex(Integer dayIndex) {
        this.dayIndex = dayIndex;
    }

    public String getTitleDate() {
        return titleDate;
    }

    public void setTitleDate(String titleDate) {
        this.titleDate = titleDate == null ? null : titleDate.trim();
    }

    public String getTitleWeek() {
        return titleWeek;
    }

    public void setTitleWeek(String titleWeek) {
        this.titleWeek = titleWeek == null ? null : titleWeek.trim();
    }

    public String getRecipesIdList() {
        return recipesIdList;
    }

    public void setRecipesIdList(String recipesIdList) {
        this.recipesIdList = recipesIdList == null ? null : recipesIdList.trim();
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}