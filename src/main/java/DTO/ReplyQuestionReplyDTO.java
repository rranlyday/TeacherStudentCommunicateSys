package DTO;

import model.ReplyQuestionReply;
import model.User;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
public class ReplyQuestionReplyDTO {

    private ReplyQuestionReply replyQuestionReply;

    private User user;

    public ReplyQuestionReply getReplyQuestionReply() {
        return replyQuestionReply;
    }

    public void setReplyQuestionReply(ReplyQuestionReply replyQuestionReply) {
        this.replyQuestionReply = replyQuestionReply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
