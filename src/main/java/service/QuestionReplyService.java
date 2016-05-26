package service;

import model.QuestionReply;

import java.util.List;


/**
 * Created by Administrator on 2016/5/26 0026.
 */
public interface QuestionReplyService {

    int addQuestionReply(Integer questionId,Integer responderId,String replyDescription);

    int deleteQuestionReply(Integer questionReplyId);

    int updateQuestionReplySelective(QuestionReply questionReply);

    int addProNum(Integer questionReplyId,Integer num);

    int addInverseNum(Integer questionReplyId,Integer num);

    List<QuestionReply> searchQuestionReplyByQuestionIdOrderByTime(Integer questionId,int curPage,int pageSize);

    List<QuestionReply> searchQuestionReplyByQuestionIdOrderByAdoptionRate(Integer questionId,int curPage,int pageSize);

    int getPageNum(Integer questionId,int pageSize);

}
