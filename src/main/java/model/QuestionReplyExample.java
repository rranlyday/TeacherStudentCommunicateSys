package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionReplyExample() {
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

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(Integer value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(Integer value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(Integer value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(Integer value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<Integer> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<Integer> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionIsNull() {
            addCriterion("reply_description is null");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionIsNotNull() {
            addCriterion("reply_description is not null");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionEqualTo(String value) {
            addCriterion("reply_description =", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionNotEqualTo(String value) {
            addCriterion("reply_description <>", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionGreaterThan(String value) {
            addCriterion("reply_description >", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("reply_description >=", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionLessThan(String value) {
            addCriterion("reply_description <", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionLessThanOrEqualTo(String value) {
            addCriterion("reply_description <=", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionLike(String value) {
            addCriterion("reply_description like", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionNotLike(String value) {
            addCriterion("reply_description not like", value, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionIn(List<String> values) {
            addCriterion("reply_description in", values, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionNotIn(List<String> values) {
            addCriterion("reply_description not in", values, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionBetween(String value1, String value2) {
            addCriterion("reply_description between", value1, value2, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andReplyDescriptionNotBetween(String value1, String value2) {
            addCriterion("reply_description not between", value1, value2, "replyDescription");
            return (Criteria) this;
        }

        public Criteria andResponderIdIsNull() {
            addCriterion("responder_id is null");
            return (Criteria) this;
        }

        public Criteria andResponderIdIsNotNull() {
            addCriterion("responder_id is not null");
            return (Criteria) this;
        }

        public Criteria andResponderIdEqualTo(Integer value) {
            addCriterion("responder_id =", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdNotEqualTo(Integer value) {
            addCriterion("responder_id <>", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdGreaterThan(Integer value) {
            addCriterion("responder_id >", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("responder_id >=", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdLessThan(Integer value) {
            addCriterion("responder_id <", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdLessThanOrEqualTo(Integer value) {
            addCriterion("responder_id <=", value, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdIn(List<Integer> values) {
            addCriterion("responder_id in", values, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdNotIn(List<Integer> values) {
            addCriterion("responder_id not in", values, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdBetween(Integer value1, Integer value2) {
            addCriterion("responder_id between", value1, value2, "responderId");
            return (Criteria) this;
        }

        public Criteria andResponderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("responder_id not between", value1, value2, "responderId");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andProNumIsNull() {
            addCriterion("pro_num is null");
            return (Criteria) this;
        }

        public Criteria andProNumIsNotNull() {
            addCriterion("pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andProNumEqualTo(Integer value) {
            addCriterion("pro_num =", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotEqualTo(Integer value) {
            addCriterion("pro_num <>", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThan(Integer value) {
            addCriterion("pro_num >", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("pro_num >=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThan(Integer value) {
            addCriterion("pro_num <", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumLessThanOrEqualTo(Integer value) {
            addCriterion("pro_num <=", value, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumIn(List<Integer> values) {
            addCriterion("pro_num in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotIn(List<Integer> values) {
            addCriterion("pro_num not in", values, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumBetween(Integer value1, Integer value2) {
            addCriterion("pro_num between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andProNumNotBetween(Integer value1, Integer value2) {
            addCriterion("pro_num not between", value1, value2, "proNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumIsNull() {
            addCriterion("inverse_num is null");
            return (Criteria) this;
        }

        public Criteria andInverseNumIsNotNull() {
            addCriterion("inverse_num is not null");
            return (Criteria) this;
        }

        public Criteria andInverseNumEqualTo(Integer value) {
            addCriterion("inverse_num =", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumNotEqualTo(Integer value) {
            addCriterion("inverse_num <>", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumGreaterThan(Integer value) {
            addCriterion("inverse_num >", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("inverse_num >=", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumLessThan(Integer value) {
            addCriterion("inverse_num <", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumLessThanOrEqualTo(Integer value) {
            addCriterion("inverse_num <=", value, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumIn(List<Integer> values) {
            addCriterion("inverse_num in", values, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumNotIn(List<Integer> values) {
            addCriterion("inverse_num not in", values, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumBetween(Integer value1, Integer value2) {
            addCriterion("inverse_num between", value1, value2, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andInverseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("inverse_num not between", value1, value2, "inverseNum");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateIsNull() {
            addCriterion("adoption_rate is null");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateIsNotNull() {
            addCriterion("adoption_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateEqualTo(Float value) {
            addCriterion("adoption_rate =", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateNotEqualTo(Float value) {
            addCriterion("adoption_rate <>", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateGreaterThan(Float value) {
            addCriterion("adoption_rate >", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateGreaterThanOrEqualTo(Float value) {
            addCriterion("adoption_rate >=", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateLessThan(Float value) {
            addCriterion("adoption_rate <", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateLessThanOrEqualTo(Float value) {
            addCriterion("adoption_rate <=", value, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateIn(List<Float> values) {
            addCriterion("adoption_rate in", values, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateNotIn(List<Float> values) {
            addCriterion("adoption_rate not in", values, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateBetween(Float value1, Float value2) {
            addCriterion("adoption_rate between", value1, value2, "adoptionRate");
            return (Criteria) this;
        }

        public Criteria andAdoptionRateNotBetween(Float value1, Float value2) {
            addCriterion("adoption_rate not between", value1, value2, "adoptionRate");
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