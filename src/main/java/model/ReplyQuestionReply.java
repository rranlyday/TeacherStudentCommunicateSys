package model;

import java.util.Date;

public class ReplyQuestionReply {
    private Integer id;

    private Integer questionReplyId;

    private String replyDescription;

    private Integer responderId;

    private Date relpyTime;

    private Integer replyProNum;

    private Integer replyInverseNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuestionReplyId() {
        return questionReplyId;
    }

    public void setQuestionReplyId(Integer questionReplyId) {
        this.questionReplyId = questionReplyId;
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

    public Date getRelpyTime() {
        return relpyTime;
    }

    public void setRelpyTime(Date relpyTime) {
        this.relpyTime = relpyTime;
    }

    public Integer getReplyProNum() {
        return replyProNum;
    }

    public void setReplyProNum(Integer replyProNum) {
        this.replyProNum = replyProNum;
    }

    public Integer getReplyInverseNum() {
        return replyInverseNum;
    }

    public void setReplyInverseNum(Integer replyInverseNum) {
        this.replyInverseNum = replyInverseNum;
    }
}