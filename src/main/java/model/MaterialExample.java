package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MaterialExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaterialExample() {
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

        public Criteria andMaterialTypeIdIsNull() {
            addCriterion("material_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdIsNotNull() {
            addCriterion("material_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdEqualTo(Integer value) {
            addCriterion("material_type_id =", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdNotEqualTo(Integer value) {
            addCriterion("material_type_id <>", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdGreaterThan(Integer value) {
            addCriterion("material_type_id >", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("material_type_id >=", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdLessThan(Integer value) {
            addCriterion("material_type_id <", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("material_type_id <=", value, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdIn(List<Integer> values) {
            addCriterion("material_type_id in", values, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdNotIn(List<Integer> values) {
            addCriterion("material_type_id not in", values, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("material_type_id between", value1, value2, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("material_type_id not between", value1, value2, "materialTypeId");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNull() {
            addCriterion("material_name is null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIsNotNull() {
            addCriterion("material_name is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialNameEqualTo(String value) {
            addCriterion("material_name =", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotEqualTo(String value) {
            addCriterion("material_name <>", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThan(String value) {
            addCriterion("material_name >", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameGreaterThanOrEqualTo(String value) {
            addCriterion("material_name >=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThan(String value) {
            addCriterion("material_name <", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLessThanOrEqualTo(String value) {
            addCriterion("material_name <=", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameLike(String value) {
            addCriterion("material_name like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotLike(String value) {
            addCriterion("material_name not like", value, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameIn(List<String> values) {
            addCriterion("material_name in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotIn(List<String> values) {
            addCriterion("material_name not in", values, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameBetween(String value1, String value2) {
            addCriterion("material_name between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andMaterialNameNotBetween(String value1, String value2) {
            addCriterion("material_name not between", value1, value2, "materialName");
            return (Criteria) this;
        }

        public Criteria andStorageAddressIsNull() {
            addCriterion("storage_address is null");
            return (Criteria) this;
        }

        public Criteria andStorageAddressIsNotNull() {
            addCriterion("storage_address is not null");
            return (Criteria) this;
        }

        public Criteria andStorageAddressEqualTo(String value) {
            addCriterion("storage_address =", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressNotEqualTo(String value) {
            addCriterion("storage_address <>", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressGreaterThan(String value) {
            addCriterion("storage_address >", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressGreaterThanOrEqualTo(String value) {
            addCriterion("storage_address >=", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressLessThan(String value) {
            addCriterion("storage_address <", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressLessThanOrEqualTo(String value) {
            addCriterion("storage_address <=", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressLike(String value) {
            addCriterion("storage_address like", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressNotLike(String value) {
            addCriterion("storage_address not like", value, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressIn(List<String> values) {
            addCriterion("storage_address in", values, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressNotIn(List<String> values) {
            addCriterion("storage_address not in", values, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressBetween(String value1, String value2) {
            addCriterion("storage_address between", value1, value2, "storageAddress");
            return (Criteria) this;
        }

        public Criteria andStorageAddressNotBetween(String value1, String value2) {
            addCriterion("storage_address not between", value1, value2, "storageAddress");
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

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIsNull() {
            addCriterion("upload_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIsNotNull() {
            addCriterion("upload_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdEqualTo(Integer value) {
            addCriterion("upload_user_id =", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotEqualTo(Integer value) {
            addCriterion("upload_user_id <>", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdGreaterThan(Integer value) {
            addCriterion("upload_user_id >", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("upload_user_id >=", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdLessThan(Integer value) {
            addCriterion("upload_user_id <", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("upload_user_id <=", value, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdIn(List<Integer> values) {
            addCriterion("upload_user_id in", values, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotIn(List<Integer> values) {
            addCriterion("upload_user_id not in", values, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdBetween(Integer value1, Integer value2) {
            addCriterion("upload_user_id between", value1, value2, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andUploadUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("upload_user_id not between", value1, value2, "uploadUserId");
            return (Criteria) this;
        }

        public Criteria andDataSizeIsNull() {
            addCriterion("data_size is null");
            return (Criteria) this;
        }

        public Criteria andDataSizeIsNotNull() {
            addCriterion("data_size is not null");
            return (Criteria) this;
        }

        public Criteria andDataSizeEqualTo(String value) {
            addCriterion("data_size =", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeNotEqualTo(String value) {
            addCriterion("data_size <>", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeGreaterThan(String value) {
            addCriterion("data_size >", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeGreaterThanOrEqualTo(String value) {
            addCriterion("data_size >=", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeLessThan(String value) {
            addCriterion("data_size <", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeLessThanOrEqualTo(String value) {
            addCriterion("data_size <=", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeLike(String value) {
            addCriterion("data_size like", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeNotLike(String value) {
            addCriterion("data_size not like", value, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeIn(List<String> values) {
            addCriterion("data_size in", values, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeNotIn(List<String> values) {
            addCriterion("data_size not in", values, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeBetween(String value1, String value2) {
            addCriterion("data_size between", value1, value2, "dataSize");
            return (Criteria) this;
        }

        public Criteria andDataSizeNotBetween(String value1, String value2) {
            addCriterion("data_size not between", value1, value2, "dataSize");
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