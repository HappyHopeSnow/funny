package com.weishu.web.recommend_food.entity;

import java.util.Date;

public class RecommendFood {
    private Long id;

    private Long recipesId;

    private Integer recipesPid;

    private Byte isShow;

    private Integer showIndex;

    private Date createTime;

    private Date updateTime;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecipesId() {
        return recipesId;
    }

    public void setRecipesId(Long recipesId) {
        this.recipesId = recipesId;
    }

    public Integer getRecipesPid() {
        return recipesPid;
    }

    public void setRecipesPid(Integer recipesPid) {
        this.recipesPid = recipesPid;
    }

    public Byte getIsShow() {
        return isShow;
    }

    public void setIsShow(Byte isShow) {
        this.isShow = isShow;
    }

    public Integer getShowIndex() {
        return showIndex;
    }

    public void setShowIndex(Integer showIndex) {
        this.showIndex = showIndex;
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