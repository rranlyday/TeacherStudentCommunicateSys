package model;

public class SubjectType {
    private Integer id;

    private String subjectTypeName;

    private String subjectTypeDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectTypeName() {
        return subjectTypeName;
    }

    public void setSubjectTypeName(String subjectTypeName) {
        this.subjectTypeName = subjectTypeName == null ? null : subjectTypeName.trim();
    }

    public String getSubjectTypeDescription() {
        return subjectTypeDescription;
    }

    public void setSubjectTypeDescription(String subjectTypeDescription) {
        this.subjectTypeDescription = subjectTypeDescription == null ? null : subjectTypeDescription.trim();
    }
}