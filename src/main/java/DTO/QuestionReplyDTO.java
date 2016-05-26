package DTO;

import model.QuestionReply;
import model.User;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
public class QuestionReplyDTO {

    private QuestionReply questionReply;
    private User user;

    public QuestionReply getQuestionReply() {
        return questionReply;
    }

    public void setQuestionReply(QuestionReply questionReply) {
        this.questionReply = questionReply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
