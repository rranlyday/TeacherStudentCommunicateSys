package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemSquareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProblemSquareExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameIsNull() {
            addCriterion("problem_square_name is null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameIsNotNull() {
            addCriterion("problem_square_name is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameEqualTo(String value) {
            addCriterion("problem_square_name =", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameNotEqualTo(String value) {
            addCriterion("problem_square_name <>", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameGreaterThan(String value) {
            addCriterion("problem_square_name >", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameGreaterThanOrEqualTo(String value) {
            addCriterion("problem_square_name >=", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameLessThan(String value) {
            addCriterion("problem_square_name <", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameLessThanOrEqualTo(String value) {
            addCriterion("problem_square_name <=", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameLike(String value) {
            addCriterion("problem_square_name like", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameNotLike(String value) {
            addCriterion("problem_square_name not like", value, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameIn(List<String> values) {
            addCriterion("problem_square_name in", values, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameNotIn(List<String> values) {
            addCriterion("problem_square_name not in", values, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameBetween(String value1, String value2) {
            addCriterion("problem_square_name between", value1, value2, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareNameNotBetween(String value1, String value2) {
            addCriterion("problem_square_name not between", value1, value2, "problemSquareName");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionIsNull() {
            addCriterion("problem_square_description is null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionIsNotNull() {
            addCriterion("problem_square_description is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionEqualTo(String value) {
            addCriterion("problem_square_description =", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionNotEqualTo(String value) {
            addCriterion("problem_square_description <>", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionGreaterThan(String value) {
            addCriterion("problem_square_description >", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("problem_square_description >=", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionLessThan(String value) {
            addCriterion("problem_square_description <", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionLessThanOrEqualTo(String value) {
            addCriterion("problem_square_description <=", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionLike(String value) {
            addCriterion("problem_square_description like", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionNotLike(String value) {
            addCriterion("problem_square_description not like", value, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionIn(List<String> values) {
            addCriterion("problem_square_description in", values, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionNotIn(List<String> values) {
            addCriterion("problem_square_description not in", values, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionBetween(String value1, String value2) {
            addCriterion("problem_square_description between", value1, value2, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareDescriptionNotBetween(String value1, String value2) {
            addCriterion("problem_square_description not between", value1, value2, "problemSquareDescription");
            return (Criteria) this;
        }

        public Criteria andAttentionNumIsNull() {
            addCriterion("attention_num is null");
            return (Criteria) this;
        }

        public Criteria andAttentionNumIsNotNull() {
            addCriterion("attention_num is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionNumEqualTo(Integer value) {
            addCriterion("attention_num =", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumNotEqualTo(Integer value) {
            addCriterion("attention_num <>", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumGreaterThan(Integer value) {
            addCriterion("attention_num >", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("attention_num >=", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumLessThan(Integer value) {
            addCriterion("attention_num <", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumLessThanOrEqualTo(Integer value) {
            addCriterion("attention_num <=", value, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumIn(List<Integer> values) {
            addCriterion("attention_num in", values, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumNotIn(List<Integer> values) {
            addCriterion("attention_num not in", values, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumBetween(Integer value1, Integer value2) {
            addCriterion("attention_num between", value1, value2, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andAttentionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("attention_num not between", value1, value2, "attentionNum");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNull() {
            addCriterion("owner_id is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIsNotNull() {
            addCriterion("owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerIdEqualTo(Integer value) {
            addCriterion("owner_id =", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotEqualTo(Integer value) {
            addCriterion("owner_id <>", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThan(Integer value) {
            addCriterion("owner_id >", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("owner_id >=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThan(Integer value) {
            addCriterion("owner_id <", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdLessThanOrEqualTo(Integer value) {
            addCriterion("owner_id <=", value, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdIn(List<Integer> values) {
            addCriterion("owner_id in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotIn(List<Integer> values) {
            addCriterion("owner_id not in", values, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdBetween(Integer value1, Integer value2) {
            addCriterion("owner_id between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andOwnerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("owner_id not between", value1, value2, "ownerId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconIsNull() {
            addCriterion("problem_square_icon is null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconIsNotNull() {
            addCriterion("problem_square_icon is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconEqualTo(String value) {
            addCriterion("problem_square_icon =", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconNotEqualTo(String value) {
            addCriterion("problem_square_icon <>", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconGreaterThan(String value) {
            addCriterion("problem_square_icon >", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconGreaterThanOrEqualTo(String value) {
            addCriterion("problem_square_icon >=", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconLessThan(String value) {
            addCriterion("problem_square_icon <", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconLessThanOrEqualTo(String value) {
            addCriterion("problem_square_icon <=", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconLike(String value) {
            addCriterion("problem_square_icon like", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconNotLike(String value) {
            addCriterion("problem_square_icon not like", value, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconIn(List<String> values) {
            addCriterion("problem_square_icon in", values, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconNotIn(List<String> values) {
            addCriterion("problem_square_icon not in", values, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconBetween(String value1, String value2) {
            addCriterion("problem_square_icon between", value1, value2, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIconNotBetween(String value1, String value2) {
            addCriterion("problem_square_icon not between", value1, value2, "problemSquareIcon");
            return (Criteria) this;
        }

        public Criteria andMessageNumIsNull() {
            addCriterion("message_num is null");
            return (Criteria) this;
        }

        public Criteria andMessageNumIsNotNull() {
            addCriterion("message_num is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNumEqualTo(Integer value) {
            addCriterion("message_num =", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotEqualTo(Integer value) {
            addCriterion("message_num <>", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumGreaterThan(Integer value) {
            addCriterion("message_num >", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_num >=", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumLessThan(Integer value) {
            addCriterion("message_num <", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumLessThanOrEqualTo(Integer value) {
            addCriterion("message_num <=", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumIn(List<Integer> values) {
            addCriterion("message_num in", values, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotIn(List<Integer> values) {
            addCriterion("message_num not in", values, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumBetween(Integer value1, Integer value2) {
            addCriterion("message_num between", value1, value2, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("message_num not between", value1, value2, "messageNum");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNull() {
            addCriterion("build_time is null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIsNotNull() {
            addCriterion("build_time is not null");
            return (Criteria) this;
        }

        public Criteria andBuildTimeEqualTo(Date value) {
            addCriterion("build_time =", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotEqualTo(Date value) {
            addCriterion("build_time <>", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThan(Date value) {
            addCriterion("build_time >", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("build_time >=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThan(Date value) {
            addCriterion("build_time <", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeLessThanOrEqualTo(Date value) {
            addCriterion("build_time <=", value, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeIn(List<Date> values) {
            addCriterion("build_time in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotIn(List<Date> values) {
            addCriterion("build_time not in", values, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeBetween(Date value1, Date value2) {
            addCriterion("build_time between", value1, value2, "buildTime");
            return (Criteria) this;
        }

        public Criteria andBuildTimeNotBetween(Date value1, Date value2) {
            addCriterion("build_time not between", value1, value2, "buildTime");
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