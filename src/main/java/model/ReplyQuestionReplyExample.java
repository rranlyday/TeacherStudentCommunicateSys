package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyQuestionReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyQuestionReplyExample() {
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

        public Criteria andQuestionReplyIdIsNull() {
            addCriterion("question_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdIsNotNull() {
            addCriterion("question_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdEqualTo(Integer value) {
            addCriterion("question_reply_id =", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdNotEqualTo(Integer value) {
            addCriterion("question_reply_id <>", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdGreaterThan(Integer value) {
            addCriterion("question_reply_id >", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("question_reply_id >=", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdLessThan(Integer value) {
            addCriterion("question_reply_id <", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("question_reply_id <=", value, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdIn(List<Integer> values) {
            addCriterion("question_reply_id in", values, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdNotIn(List<Integer> values) {
            addCriterion("question_reply_id not in", values, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("question_reply_id between", value1, value2, "questionReplyId");
            return (Criteria) this;
        }

        public Criteria andQuestionReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("question_reply_id not between", value1, value2, "questionReplyId");
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

        public Criteria andRelpyTimeIsNull() {
            addCriterion("relpy_time is null");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeIsNotNull() {
            addCriterion("relpy_time is not null");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeEqualTo(Date value) {
            addCriterion("relpy_time =", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeNotEqualTo(Date value) {
            addCriterion("relpy_time <>", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeGreaterThan(Date value) {
            addCriterion("relpy_time >", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("relpy_time >=", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeLessThan(Date value) {
            addCriterion("relpy_time <", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeLessThanOrEqualTo(Date value) {
            addCriterion("relpy_time <=", value, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeIn(List<Date> values) {
            addCriterion("relpy_time in", values, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeNotIn(List<Date> values) {
            addCriterion("relpy_time not in", values, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeBetween(Date value1, Date value2) {
            addCriterion("relpy_time between", value1, value2, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andRelpyTimeNotBetween(Date value1, Date value2) {
            addCriterion("relpy_time not between", value1, value2, "relpyTime");
            return (Criteria) this;
        }

        public Criteria andReplyProNumIsNull() {
            addCriterion("reply_pro_num is null");
            return (Criteria) this;
        }

        public Criteria andReplyProNumIsNotNull() {
            addCriterion("reply_pro_num is not null");
            return (Criteria) this;
        }

        public Criteria andReplyProNumEqualTo(Integer value) {
            addCriterion("reply_pro_num =", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumNotEqualTo(Integer value) {
            addCriterion("reply_pro_num <>", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumGreaterThan(Integer value) {
            addCriterion("reply_pro_num >", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_pro_num >=", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumLessThan(Integer value) {
            addCriterion("reply_pro_num <", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumLessThanOrEqualTo(Integer value) {
            addCriterion("reply_pro_num <=", value, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumIn(List<Integer> values) {
            addCriterion("reply_pro_num in", values, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumNotIn(List<Integer> values) {
            addCriterion("reply_pro_num not in", values, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumBetween(Integer value1, Integer value2) {
            addCriterion("reply_pro_num between", value1, value2, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyProNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_pro_num not between", value1, value2, "replyProNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumIsNull() {
            addCriterion("reply_inverse_num is null");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumIsNotNull() {
            addCriterion("reply_inverse_num is not null");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumEqualTo(Integer value) {
            addCriterion("reply_inverse_num =", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumNotEqualTo(Integer value) {
            addCriterion("reply_inverse_num <>", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumGreaterThan(Integer value) {
            addCriterion("reply_inverse_num >", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_inverse_num >=", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumLessThan(Integer value) {
            addCriterion("reply_inverse_num <", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumLessThanOrEqualTo(Integer value) {
            addCriterion("reply_inverse_num <=", value, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumIn(List<Integer> values) {
            addCriterion("reply_inverse_num in", values, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumNotIn(List<Integer> values) {
            addCriterion("reply_inverse_num not in", values, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumBetween(Integer value1, Integer value2) {
            addCriterion("reply_inverse_num between", value1, value2, "replyInverseNum");
            return (Criteria) this;
        }

        public Criteria andReplyInverseNumNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_inverse_num not between", value1, value2, "replyInverseNum");
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