package service;

import model.ReplyQuestionReply;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
public interface ReplyQuestionReplyService {

    int addReplyQuestionReply(Integer questionReplyId,Integer responderId, String replyDescription);

    int deleteReplyQuestionReply(Integer replyQuestionReplyId);

    int addProNum(Integer replyQuestionReplyId,Integer num);

    int addInverseNum(Integer replyQuestionReplyId,Integer num);

    List<ReplyQuestionReply> searchReplyQuestionReplyOrderByTime(Integer questionReplyId,Integer curPage,Integer pageSize);

    List<ReplyQuestionReply> searchReplyQuestionReplyOrderByTime(Integer questionReplyId);
}
