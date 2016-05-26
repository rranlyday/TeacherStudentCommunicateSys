package service.impl;

import dao.ProblemSquareMapper;
import model.ProblemSquare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProblemSquareService;
import util.TimeUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
@Service("problemSquareService")
public class ProblemSquareServiceImpl implements ProblemSquareService {

    @Autowired
    ProblemSquareMapper problemSquareMapper;

    public int bulidProblemSquare(ProblemSquare p) {

        Date date = TimeUtil.getNowSysTime();
        p.setBuildTime(date);
        int rs = problemSquareMapper.insertSelective(p);
        System.out.println(rs);

        return p.getId();
    }

    public List<ProblemSquare> selectProblemSquareOrderByTime(int pageNum, int size) {
        int begin = size*pageNum;
        return problemSquareMapper.selectProblemSquareOrderByTime(begin,size);
    }

    public int selectProblemSquareCount() {
        return problemSquareMapper.countByExample(null);
    }

    public List<ProblemSquare> selectProblemSquareOrderByTime(int pageNum, int size,String condition) {
        if (condition == null)
             return selectProblemSquareOrderByTime(pageNum,size);
        return  null;

  }

    public int selectProblemSquareCount(String condition) {
        return 0;
    }

    public int addQuestionNum(Integer problemSquareId,Integer questionNum) {
        ProblemSquare problemSquare = problemSquareMapper.selectByPrimaryKey(problemSquareId);
        int messageNum = problemSquare.getMessageNum();
        problemSquare.setMessageNum(messageNum+questionNum);  //增加消息数量
        if (problemSquareMapper.updateByPrimaryKeySelective(problemSquare) >0){
            return messageNum+questionNum ;
        }
        return  -1;
    }

    public int addAttentionNum(Integer problemSquareId, Integer attentionNum) {
        ProblemSquare problemSquare = problemSquareMapper.selectByPrimaryKey(problemSquareId);
        int attention = problemSquare.getAttentionNum();
        problemSquare.setAttentionNum(attention + attentionNum);  //增加消息数量
        if (problemSquareMapper.updateByPrimaryKeySelective(problemSquare) >0){
            return attention+attentionNum ;
        }
        return  -1;
    }

    public int reduceAttentionNum(Integer problemSquareId, Integer attentionNum) {
        ProblemSquare problemSquare = problemSquareMapper.selectByPrimaryKey(problemSquareId);
        int attention = problemSquare.getAttentionNum();
        problemSquare.setAttentionNum(attention-attentionNum);  //增加消息数量
        if (problemSquareMapper.updateByPrimaryKeySelective(problemSquare) >0){
            return attention+attentionNum ;
        }
        return  -1;
    }
}
