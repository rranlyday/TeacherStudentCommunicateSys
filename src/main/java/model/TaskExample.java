package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskExample() {
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

        public Criteria andTaskTitleIsNull() {
            addCriterion("task_title is null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIsNotNull() {
            addCriterion("task_title is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTitleEqualTo(String value) {
            addCriterion("task_title =", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotEqualTo(String value) {
            addCriterion("task_title <>", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThan(String value) {
            addCriterion("task_title >", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleGreaterThanOrEqualTo(String value) {
            addCriterion("task_title >=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThan(String value) {
            addCriterion("task_title <", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLessThanOrEqualTo(String value) {
            addCriterion("task_title <=", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleLike(String value) {
            addCriterion("task_title like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotLike(String value) {
            addCriterion("task_title not like", value, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleIn(List<String> values) {
            addCriterion("task_title in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotIn(List<String> values) {
            addCriterion("task_title not in", values, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleBetween(String value1, String value2) {
            addCriterion("task_title between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskTitleNotBetween(String value1, String value2) {
            addCriterion("task_title not between", value1, value2, "taskTitle");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionIsNull() {
            addCriterion("task_decription is null");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionIsNotNull() {
            addCriterion("task_decription is not null");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionEqualTo(String value) {
            addCriterion("task_decription =", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionNotEqualTo(String value) {
            addCriterion("task_decription <>", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionGreaterThan(String value) {
            addCriterion("task_decription >", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionGreaterThanOrEqualTo(String value) {
            addCriterion("task_decription >=", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionLessThan(String value) {
            addCriterion("task_decription <", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionLessThanOrEqualTo(String value) {
            addCriterion("task_decription <=", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionLike(String value) {
            addCriterion("task_decription like", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionNotLike(String value) {
            addCriterion("task_decription not like", value, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionIn(List<String> values) {
            addCriterion("task_decription in", values, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionNotIn(List<String> values) {
            addCriterion("task_decription not in", values, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionBetween(String value1, String value2) {
            addCriterion("task_decription between", value1, value2, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andTaskDecriptionNotBetween(String value1, String value2) {
            addCriterion("task_decription not between", value1, value2, "taskDecription");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdIsNull() {
            addCriterion("problem_square_id is null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdIsNotNull() {
            addCriterion("problem_square_id is not null");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdEqualTo(Integer value) {
            addCriterion("problem_square_id =", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdNotEqualTo(Integer value) {
            addCriterion("problem_square_id <>", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdGreaterThan(Integer value) {
            addCriterion("problem_square_id >", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("problem_square_id >=", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdLessThan(Integer value) {
            addCriterion("problem_square_id <", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdLessThanOrEqualTo(Integer value) {
            addCriterion("problem_square_id <=", value, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdIn(List<Integer> values) {
            addCriterion("problem_square_id in", values, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdNotIn(List<Integer> values) {
            addCriterion("problem_square_id not in", values, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdBetween(Integer value1, Integer value2) {
            addCriterion("problem_square_id between", value1, value2, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andProblemSquareIdNotBetween(Integer value1, Integer value2) {
            addCriterion("problem_square_id not between", value1, value2, "problemSquareId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdIsNull() {
            addCriterion("pulisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPulisherIdIsNotNull() {
            addCriterion("pulisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPulisherIdEqualTo(Integer value) {
            addCriterion("pulisher_id =", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdNotEqualTo(Integer value) {
            addCriterion("pulisher_id <>", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdGreaterThan(Integer value) {
            addCriterion("pulisher_id >", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pulisher_id >=", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdLessThan(Integer value) {
            addCriterion("pulisher_id <", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("pulisher_id <=", value, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdIn(List<Integer> values) {
            addCriterion("pulisher_id in", values, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdNotIn(List<Integer> values) {
            addCriterion("pulisher_id not in", values, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdBetween(Integer value1, Integer value2) {
            addCriterion("pulisher_id between", value1, value2, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pulisher_id not between", value1, value2, "pulisherId");
            return (Criteria) this;
        }

        public Criteria andPulishTimeIsNull() {
            addCriterion("pulish_time is null");
            return (Criteria) this;
        }

        public Criteria andPulishTimeIsNotNull() {
            addCriterion("pulish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPulishTimeEqualTo(Date value) {
            addCriterion("pulish_time =", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeNotEqualTo(Date value) {
            addCriterion("pulish_time <>", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeGreaterThan(Date value) {
            addCriterion("pulish_time >", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pulish_time >=", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeLessThan(Date value) {
            addCriterion("pulish_time <", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeLessThanOrEqualTo(Date value) {
            addCriterion("pulish_time <=", value, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeIn(List<Date> values) {
            addCriterion("pulish_time in", values, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeNotIn(List<Date> values) {
            addCriterion("pulish_time not in", values, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeBetween(Date value1, Date value2) {
            addCriterion("pulish_time between", value1, value2, "pulishTime");
            return (Criteria) this;
        }

        public Criteria andPulishTimeNotBetween(Date value1, Date value2) {
            addCriterion("pulish_time not between", value1, value2, "pulishTime");
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