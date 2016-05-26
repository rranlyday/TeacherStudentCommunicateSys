package model;

import java.util.Date;

public class QuestionReply {
    private Integer id;

    private Integer questionId;

    private String replyDescription;

    private Integer responderId;

    private Date replyTime;

    private Integer proNum;

    private Integer inverseNum;

    private Float adoptionRate;

    private Integer replyNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getReplyDescription() {
        return replyDescription;
    }

    public void setReplyDescription(String replyDescription) {
        this.replyDescription = replyDescription == null ? null : replyDescription.trim();
    }

    public Integer getResponderId() {
        return responderId;
    }

    public void setResponderId(Integer responderId) {
        this.responderId = responderId;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getInverseNum() {
        return inverseNum;
    }

    public void setInverseNum(Integer inverseNum) {
        this.inverseNum = inverseNum;
    }

    public Float getAdoptionRate() {
        return adoptionRate;
    }

    public void setAdoptionRate(Float adoptionRate) {
        this.adoptionRate = adoptionRate;
    }

    public Integer getReplyNumber() {
        return replyNumber;
    }

    public void setReplyNumber(Integer replyNumber) {
        this.replyNumber = replyNumber;
    }
}