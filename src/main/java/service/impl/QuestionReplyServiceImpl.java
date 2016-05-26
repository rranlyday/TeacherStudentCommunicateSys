package service.impl;

import dao.QuestionReplyMapper;
import model.QuestionReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.QuestionReplyService;
import util.MathUtil;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
@Service("questionReplyService")
public class QuestionReplyServiceImpl implements QuestionReplyService{

    @Autowired
    QuestionReplyMapper questionReplyMapper;

    public int addQuestionReply(Integer questionId, Integer responderId, String replyDescription) {
        QuestionReply questionReply = new QuestionReply();
        questionReply.setQuestionId(questionId);
        questionReply.setResponderId(responderId);
        questionReply.setReplyDescription(replyDescription);

        Date date = TimeUtil.getNowSysTime();
        questionReply.setReplyTime(date);

        int row = questionReplyMapper.insertSelective(questionReply);
        return questionReply.getId();
    }

    public int deleteQuestionReply(Integer questionReplyId) {
        return questionReplyMapper.deleteByPrimaryKey(questionReplyId);
    }

    public int updateQuestionReplySelective(QuestionReply questionReply) {
        return questionReplyMapper.updateByPrimaryKeySelective(questionReply);
    }

    public int addProNum(Integer questionReplyId, Integer num) {
        QuestionReply questionReply = questionReplyMapper.selectByPrimaryKey(questionReplyId);
        int proNum = questionReply.getProNum()+num;
        questionReply.setProNum(proNum);
        return questionReplyMapper.updateByPrimaryKeySelective(questionReply);
    }

    public int addInverseNum(Integer questionReplyId, Integer num) {
        QuestionReply questionReply = questionReplyMapper.selectByPrimaryKey(questionReplyId);
        int inverseNum = questionReply.getInverseNum() +num;
        questionReply.setInverseNum(inverseNum);
        return questionReplyMapper.updateByPrimaryKeySelective(questionReply);
    }

    public List<QuestionReply> searchQuestionReplyByQuestionIdOrderByAdoptionRate(Integer questionId, int curPage, int pageSize) {
        int beginPos = curPage * pageSize;

        return questionReplyMapper.searchQuestionReplyByQuestionIdOrderByAdoptionRate(questionId,beginPos,pageSize);
    }

    public List<QuestionReply> searchQuestionReplyByQuestionIdOrderByTime(Integer questionId, int curPage, int pageSize) {
        int beginPos = curPage * pageSize;
        return questionReplyMapper.searchQuestionReplyByQuestionIdOrderByTime(questionId,beginPos,pageSize);
    }

    public int getPageNum(Integer questionId, int pageSize) {
        int count = questionReplyMapper.selectCountByQuestionId(questionId);
        int pageNum = MathUtil.numToPageTotal(count,pageSize);
        return pageNum;
    }
}

