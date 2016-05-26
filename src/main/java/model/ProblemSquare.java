package model;

import java.util.Date;

public class ProblemSquare {
    private Integer id;

    private String problemSquareName;

    private String problemSquareDescription;

    private Integer attentionNum;

    private Integer ownerId;

    private String problemSquareIcon;

    private Integer messageNum;

    private Date buildTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblemSquareName() {
        return problemSquareName;
    }

    public void setProblemSquareName(String problemSquareName) {
        this.problemSquareName = problemSquareName == null ? null : problemSquareName.trim();
    }

    public String getProblemSquareDescription() {
        return problemSquareDescription;
    }

    public void setProblemSquareDescription(String problemSquareDescription) {
        this.problemSquareDescription = problemSquareDescription == null ? null : problemSquareDescription.trim();
    }

    public Integer getAttentionNum() {
        return attentionNum;
    }

    public void setAttentionNum(Integer attentionNum) {
        this.attentionNum = attentionNum;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getProblemSquareIcon() {
        return problemSquareIcon;
    }

    public void setProblemSquareIcon(String problemSquareIcon) {
        this.problemSquareIcon = problemSquareIcon == null ? null : problemSquareIcon.trim();
    }

    public Integer getMessageNum() {
        return messageNum;
    }

    public void setMessageNum(Integer messageNum) {
        this.messageNum = messageNum;
    }

    public Date getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(Date buildTime) {
        this.buildTime = buildTime;
    }
}