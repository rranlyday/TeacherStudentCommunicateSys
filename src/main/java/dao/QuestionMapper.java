package dao;

import java.util.List;
import model.Question;
import model.QuestionExample;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    int countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<Question> selectQuestionOrderByTimeByProblemSquareId(@Param("problemSquareId") int problemSquareId,@Param("beginPos") int beginPos,
                                                              @Param("pageSize")int pageSize);

    Integer searchQuestioNumByProblemSquareId(Integer problemSquareId);
}