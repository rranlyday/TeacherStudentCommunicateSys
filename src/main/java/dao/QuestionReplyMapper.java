package dao;

import java.util.List;
import model.QuestionReply;
import model.QuestionReplyExample;
import org.apache.ibatis.annotations.Param;

public interface QuestionReplyMapper {
    int countByExample(QuestionReplyExample example);

    int deleteByExample(QuestionReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QuestionReply record);

    int insertSelective(QuestionReply record);

    List<QuestionReply> selectByExample(QuestionReplyExample example);

    QuestionReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QuestionReply record, @Param("example") QuestionReplyExample example);

    int updateByExample(@Param("record") QuestionReply record, @Param("example") QuestionReplyExample example);

    int updateByPrimaryKeySelective(QuestionReply record);

    int updateByPrimaryKey(QuestionReply record);

    List<QuestionReply> searchQuestionReplyByQuestionIdOrderByAdoptionRate(@Param("questionId")Integer questionId,
                                                                           @Param("beginPos")Integer beginPos,
                                                                           @Param("pageSize")Integer pageSize);

    List<QuestionReply> searchQuestionReplyByQuestionIdOrderByTime(@Param("questionId")Integer questionId,
                                                                   @Param("beginPos") int beginPos,
                                                                   @Param("pageSize")int pageSize);

    int selectCountByQuestionId(Integer questionId);
}