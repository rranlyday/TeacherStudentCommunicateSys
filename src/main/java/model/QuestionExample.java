package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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

        public Criteria andQuestionTitleIsNull() {
            addCriterion("question_title is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIsNotNull() {
            addCriterion("question_title is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleEqualTo(String value) {
            addCriterion("question_title =", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotEqualTo(String value) {
            addCriterion("question_title <>", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThan(String value) {
            addCriterion("question_title >", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("question_title >=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThan(String value) {
            addCriterion("question_title <", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLessThanOrEqualTo(String value) {
            addCriterion("question_title <=", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleLike(String value) {
            addCriterion("question_title like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotLike(String value) {
            addCriterion("question_title not like", value, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleIn(List<String> values) {
            addCriterion("question_title in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotIn(List<String> values) {
            addCriterion("question_title not in", values, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleBetween(String value1, String value2) {
            addCriterion("question_title between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionTitleNotBetween(String value1, String value2) {
            addCriterion("question_title not between", value1, value2, "questionTitle");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIsNull() {
            addCriterion("question_description is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIsNotNull() {
            addCriterion("question_description is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionEqualTo(String value) {
            addCriterion("question_description =", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotEqualTo(String value) {
            addCriterion("question_description <>", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionGreaterThan(String value) {
            addCriterion("question_description >", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("question_description >=", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLessThan(String value) {
            addCriterion("question_description <", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLessThanOrEqualTo(String value) {
            addCriterion("question_description <=", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionLike(String value) {
            addCriterion("question_description like", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotLike(String value) {
            addCriterion("question_description not like", value, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionIn(List<String> values) {
            addCriterion("question_description in", values, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotIn(List<String> values) {
            addCriterion("question_description not in", values, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionBetween(String value1, String value2) {
            addCriterion("question_description between", value1, value2, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionDescriptionNotBetween(String value1, String value2) {
            addCriterion("question_description not between", value1, value2, "questionDescription");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdIsNull() {
            addCriterion("questioner_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdIsNotNull() {
            addCriterion("questioner_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdEqualTo(Integer value) {
            addCriterion("questioner_id =", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotEqualTo(Integer value) {
            addCriterion("questioner_id <>", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdGreaterThan(Integer value) {
            addCriterion("questioner_id >", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("questioner_id >=", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdLessThan(Integer value) {
            addCriterion("questioner_id <", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdLessThanOrEqualTo(Integer value) {
            addCriterion("questioner_id <=", value, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdIn(List<Integer> values) {
            addCriterion("questioner_id in", values, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotIn(List<Integer> values) {
            addCriterion("questioner_id not in", values, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdBetween(Integer value1, Integer value2) {
            addCriterion("questioner_id between", value1, value2, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("questioner_id not between", value1, value2, "questionerId");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIsNull() {
            addCriterion("question_time is null");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIsNotNull() {
            addCriterion("question_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeEqualTo(Date value) {
            addCriterion("question_time =", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotEqualTo(Date value) {
            addCriterion("question_time <>", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeGreaterThan(Date value) {
            addCriterion("question_time >", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("question_time >=", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeLessThan(Date value) {
            addCriterion("question_time <", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeLessThanOrEqualTo(Date value) {
            addCriterion("question_time <=", value, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeIn(List<Date> values) {
            addCriterion("question_time in", values, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotIn(List<Date> values) {
            addCriterion("question_time not in", values, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeBetween(Date value1, Date value2) {
            addCriterion("question_time between", value1, value2, "questionTime");
            return (Criteria) this;
        }

        public Criteria andQuestionTimeNotBetween(Date value1, Date value2) {
            addCriterion("question_time not between", value1, value2, "questionTime");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIsNull() {
            addCriterion("reply_number is null");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIsNotNull() {
            addCriterion("reply_number is not null");
            return (Criteria) this;
        }

        public Criteria andReplyNumberEqualTo(Integer value) {
            addCriterion("reply_number =", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotEqualTo(Integer value) {
            addCriterion("reply_number <>", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberGreaterThan(Integer value) {
            addCriterion("reply_number >", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_number >=", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberLessThan(Integer value) {
            addCriterion("reply_number <", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberLessThanOrEqualTo(Integer value) {
            addCriterion("reply_number <=", value, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberIn(List<Integer> values) {
            addCriterion("reply_number in", values, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotIn(List<Integer> values) {
            addCriterion("reply_number not in", values, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberBetween(Integer value1, Integer value2) {
            addCriterion("reply_number between", value1, value2, "replyNumber");
            return (Criteria) this;
        }

        public Criteria andReplyNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_number not between", value1, value2, "replyNumber");
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