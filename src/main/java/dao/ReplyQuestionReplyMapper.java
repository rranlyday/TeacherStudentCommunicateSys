package dao;

import java.util.List;
import model.ReplyQuestionReply;
import model.ReplyQuestionReplyExample;
import org.apache.ibatis.annotations.Param;

public interface ReplyQuestionReplyMapper {
    int countByExample(ReplyQuestionReplyExample example);

    int deleteByExample(ReplyQuestionReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReplyQuestionReply record);

    int insertSelective(ReplyQuestionReply record);

    List<ReplyQuestionReply> selectByExample(ReplyQuestionReplyExample example);

    ReplyQuestionReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReplyQuestionReply record, @Param("example") ReplyQuestionReplyExample example);

    int updateByExample(@Param("record") ReplyQuestionReply record, @Param("example") ReplyQuestionReplyExample example);

    int updateByPrimaryKeySelective(ReplyQuestionReply record);

    int updateByPrimaryKey(ReplyQuestionReply record);

    List<ReplyQuestionReply> searchReplyQuestionReplyOrderByTime(@Param("questionReplyId")Integer questionReplyId,
                                                                 @Param("beginPos")Integer beginPos,
                                                                 @Param("pageSize") Integer pageSize);
}