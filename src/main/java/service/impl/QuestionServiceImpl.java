package service.impl;

import dao.QuestionMapper;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.QuestionService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    public List<Question> searchQuestionOrderByTimeByProblemSquareId(int problemSquareId,int curPage,int pageSzie) {
        int beginPos = curPage*pageSzie ;
        return questionMapper.selectQuestionOrderByTimeByProblemSquareId(problemSquareId,beginPos,pageSzie);
    }

    public int buildQuestion(Integer questionerId, Integer problemSquareId,String questionTitle, String questionDescription) {
        Question question = new Question();
        question.setQuestionerId(questionerId);
        question.setQuestionTitle(questionTitle);
        question.setQuestionDescription(questionDescription);
        question.setProblemSquareId(problemSquareId);

        Date questionTime = TimeUtil.getNowSysTime();
        question.setQuestionTime(questionTime);

        int row =  questionMapper.insertSelective(question);
        return question.getId();
    }

    public int searchQuestioNumByProblemSquareId(Integer problemSquareId) {
        Integer rs = questionMapper.searchQuestioNumByProblemSquareId(problemSquareId);
        if (rs == null)
            return  0;
        return rs;
    }

    public int deleteQuestion(Integer questionId) {
        return questionMapper.deleteByPrimaryKey(questionId);
    }

    public Question searchQuestionById(Integer id) {
        return questionMapper.selectByPrimaryKey(id);
    }

    public int addReplyNum(Integer questionId, Integer num) {
        Question question = questionMapper.selectByPrimaryKey(questionId);
        int replyNumber = question.getReplyNumber()+num;
        question.setReplyNumber(replyNumber);
        return questionMapper.updateByPrimaryKeySelective(question);
    }
}
