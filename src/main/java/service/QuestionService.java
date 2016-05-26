package service;

import model.Question;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface QuestionService {

    List<Question> searchQuestionOrderByTimeByProblemSquareId(int problemSquareId,int curPage,int pageSzie);

    int buildQuestion(Integer questionerId,Integer problemSquareId,String questionTitle,String questionDescription);

    int searchQuestioNumByProblemSquareId(Integer problemSquareId);

    int deleteQuestion(Integer questionId);
}
