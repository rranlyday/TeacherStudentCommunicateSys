package model;

public class QuestionType {
    private Integer id;

    private String questionTypeName;

    private String questionTypeDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName == null ? null : questionTypeName.trim();
    }

    public String getQuestionTypeDescription() {
        return questionTypeDescription;
    }

    public void setQuestionTypeDescription(String questionTypeDescription) {
        this.questionTypeDescription = questionTypeDescription == null ? null : questionTypeDescription.trim();
    }
}