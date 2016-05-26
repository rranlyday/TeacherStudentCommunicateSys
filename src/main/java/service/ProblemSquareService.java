package service;

import model.ProblemSquare;

import java.util.List;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public interface ProblemSquareService {

    int bulidProblemSquare(ProblemSquare p);

    List<ProblemSquare> selectProblemSquareOrderByTime(int pageNum,int size);

    int  selectProblemSquareCount();

    List<ProblemSquare> selectProblemSquareOrderByTime(int pageNum,int size,String condition);

    int  selectProblemSquareCount(String condition);

    int addQuestionNum(Integer problemSquareId,Integer questionNum);

    int addAttentionNum(Integer problemSquareId,Integer attentionNum);

    int reduceAttentionNum(Integer problemSquareId,Integer attentionNum);



}
