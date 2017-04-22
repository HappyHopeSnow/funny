package com.weishu.web.recommend_food.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecommendFoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RecommendFoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRecipesIdIsNull() {
            addCriterion("recipes_id is null");
            return (Criteria) this;
        }

        public Criteria andRecipesIdIsNotNull() {
            addCriterion("recipes_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecipesIdEqualTo(Long value) {
            addCriterion("recipes_id =", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdNotEqualTo(Long value) {
            addCriterion("recipes_id <>", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdGreaterThan(Long value) {
            addCriterion("recipes_id >", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recipes_id >=", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdLessThan(Long value) {
            addCriterion("recipes_id <", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdLessThanOrEqualTo(Long value) {
            addCriterion("recipes_id <=", value, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdIn(List<Long> values) {
            addCriterion("recipes_id in", values, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdNotIn(List<Long> values) {
            addCriterion("recipes_id not in", values, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdBetween(Long value1, Long value2) {
            addCriterion("recipes_id between", value1, value2, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesIdNotBetween(Long value1, Long value2) {
            addCriterion("recipes_id not between", value1, value2, "recipesId");
            return (Criteria) this;
        }

        public Criteria andRecipesPidIsNull() {
            addCriterion("recipes_pid is null");
            return (Criteria) this;
        }

        public Criteria andRecipesPidIsNotNull() {
            addCriterion("recipes_pid is not null");
            return (Criteria) this;
        }

        public Criteria andRecipesPidEqualTo(Integer value) {
            addCriterion("recipes_pid =", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidNotEqualTo(Integer value) {
            addCriterion("recipes_pid <>", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidGreaterThan(Integer value) {
            addCriterion("recipes_pid >", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("recipes_pid >=", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidLessThan(Integer value) {
            addCriterion("recipes_pid <", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidLessThanOrEqualTo(Integer value) {
            addCriterion("recipes_pid <=", value, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidIn(List<Integer> values) {
            addCriterion("recipes_pid in", values, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidNotIn(List<Integer> values) {
            addCriterion("recipes_pid not in", values, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidBetween(Integer value1, Integer value2) {
            addCriterion("recipes_pid between", value1, value2, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andRecipesPidNotBetween(Integer value1, Integer value2) {
            addCriterion("recipes_pid not between", value1, value2, "recipesPid");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Byte value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Byte value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Byte value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Byte value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Byte value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Byte> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Byte> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Byte value1, Byte value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andShowIndexIsNull() {
            addCriterion("show_index is null");
            return (Criteria) this;
        }

        public Criteria andShowIndexIsNotNull() {
            addCriterion("show_index is not null");
            return (Criteria) this;
        }

        public Criteria andShowIndexEqualTo(Integer value) {
            addCriterion("show_index =", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotEqualTo(Integer value) {
            addCriterion("show_index <>", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexGreaterThan(Integer value) {
            addCriterion("show_index >", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_index >=", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexLessThan(Integer value) {
            addCriterion("show_index <", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexLessThanOrEqualTo(Integer value) {
            addCriterion("show_index <=", value, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexIn(List<Integer> values) {
            addCriterion("show_index in", values, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotIn(List<Integer> values) {
            addCriterion("show_index not in", values, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexBetween(Integer value1, Integer value2) {
            addCriterion("show_index between", value1, value2, "showIndex");
            return (Criteria) this;
        }

        public Criteria andShowIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("show_index not between", value1, value2, "showIndex");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Byte value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Byte value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Byte value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Byte value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Byte value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Byte> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Byte> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Byte value1, Byte value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Byte value1, Byte value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}