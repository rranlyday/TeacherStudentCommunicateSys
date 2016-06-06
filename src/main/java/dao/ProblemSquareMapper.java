package dao;

import java.util.List;
import model.ProblemSquare;
import model.ProblemSquareExample;
import org.apache.ibatis.annotations.Param;

public interface ProblemSquareMapper {
    int countByExample(ProblemSquareExample example);

    int deleteByExample(ProblemSquareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProblemSquare record);

    int insertSelective(ProblemSquare record);

    List<ProblemSquare> selectByExample(ProblemSquareExample example);

    ProblemSquare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProblemSquare record, @Param("example") ProblemSquareExample example);

    int updateByExample(@Param("record") ProblemSquare record, @Param("example") ProblemSquareExample example);

    int updateByPrimaryKeySelective(ProblemSquare record);

    int updateByPrimaryKey(ProblemSquare record);

    List<ProblemSquare> selectProblemSquareOrderByTime(@Param("beginNum")int beginNum, @Param("sizeNum")int sizeNum);

    List<ProblemSquare> selectProblemSquareByCondition(@Param("beginNum")int beginNum, @Param("sizeNum")int sizeNum,@Param("condition")String condition);

    int selectProblemSquareCount(String condition);
}