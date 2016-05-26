package dao;

import java.util.List;

import model.User;
import model.UserProblemSquare;
import model.UserProblemSquareExample;
import org.apache.ibatis.annotations.Param;

public interface UserProblemSquareMapper {
    int countByExample(UserProblemSquareExample example);

    int deleteByExample(UserProblemSquareExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserProblemSquare record);

    int insertSelective(UserProblemSquare record);

    List<UserProblemSquare> selectByExample(UserProblemSquareExample example);

    UserProblemSquare selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserProblemSquare record, @Param("example") UserProblemSquareExample example);

    int updateByExample(@Param("record") UserProblemSquare record, @Param("example") UserProblemSquareExample example);

    int updateByPrimaryKeySelective(UserProblemSquare record);

    int updateByPrimaryKey(UserProblemSquare record);

    int cancelAttention(UserProblemSquare userProblemSquare);
}