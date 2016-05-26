package model;

public class Subject {
    private Integer id;

    private String subjectName;

    private String subjectDescription;

    private Integer subjectTypeid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription == null ? null : subjectDescription.trim();
    }

    public Integer getSubjectTypeid() {
        return subjectTypeid;
    }

    public void setSubjectTypeid(Integer subjectTypeid) {
        this.subjectTypeid = subjectTypeid;
    }
}