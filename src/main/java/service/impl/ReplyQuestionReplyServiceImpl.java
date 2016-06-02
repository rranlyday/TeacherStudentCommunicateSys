package service.impl;

import dao.ReplyQuestionReplyMapper;
import model.ReplyQuestionReply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ReplyQuestionReplyService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
@Service("replyQuestionReplyService")
public class ReplyQuestionReplyServiceImpl implements ReplyQuestionReplyService{

    @Autowired
    ReplyQuestionReplyMapper replyQuestionReplyMapper;

    public int addInverseNum(Integer replyQuestionReplyId, Integer num) {
        ReplyQuestionReply replyQuestionReply = replyQuestionReplyMapper.selectByPrimaryKey(replyQuestionReplyId);
        int inverseNum = replyQuestionReply.getReplyInverseNum() + num ;
        replyQuestionReply.setReplyInverseNum(inverseNum);
        return replyQuestionReplyMapper.updateByPrimaryKey(replyQuestionReply);
    }

    public int addProNum(Integer replyQuestionReplyId, Integer num) {
        ReplyQuestionReply replyQuestionReply = replyQuestionReplyMapper.selectByPrimaryKey(replyQuestionReplyId);
        int proNum = replyQuestionReply.getReplyProNum() + num ;
        replyQuestionReply.setReplyProNum(proNum);
        return replyQuestionReplyMapper.updateByPrimaryKey(replyQuestionReply);
    }

    public int deleteReplyQuestionReply(Integer replyQuestionReplyId) {
        return replyQuestionReplyMapper.deleteByPrimaryKey(replyQuestionReplyId);
    }

    public int addReplyQuestionReply(Integer questionReplyId, Integer responderId, String replyDescription) {
        ReplyQuestionReply replyQuestionReply = new ReplyQuestionReply();
        replyQuestionReply.setQuestionReplyId(questionReplyId);
        replyQuestionReply.setResponderId(responderId);
        replyQuestionReply.setReplyDescription(replyDescription);

        Date replyTime = TimeUtil.getNowSysTime();
        replyQuestionReply.setRelpyTime(replyTime);

        int row = replyQuestionReplyMapper.insertSelective(replyQuestionReply);
        return replyQuestionReply.getId();
    }

    public List<ReplyQuestionReply> searchReplyQuestionReplyOrderByTime(Integer questionReplyId, Integer curPage,
                                                                        Integer pageSize) {
        int beginPos = curPage * pageSize ;
        return replyQuestionReplyMapper.searchReplyQuestionReplyOrderByTimePaging(questionReplyId,beginPos,pageSize);
    }

    public List<ReplyQuestionReply> searchReplyQuestionReplyOrderByTime(Integer questionReplyId) {
        return replyQuestionReplyMapper.searchReplyQuestionReplyOrderByTime(questionReplyId);
    }
}
