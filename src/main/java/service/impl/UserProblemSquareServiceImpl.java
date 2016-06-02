package service.impl;

import dao.UserProblemSquareMapper;
import model.UserProblemSquare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserProblemSquareService;

import java.util.List;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Service("userProblemSquareService")
public class UserProblemSquareServiceImpl implements UserProblemSquareService {

    @Autowired
    UserProblemSquareMapper userProblemSquareMapper;

    public int addAttention(int userId, int problemSquareId) {
        UserProblemSquare userProblemSquare = new UserProblemSquare();
        userProblemSquare.setUserId(userId);
        userProblemSquare.setProblemSquareId(problemSquareId);

        return userProblemSquareMapper.insertSelective(userProblemSquare);
    }

    public int cancelAttention(int userId, int problemSquareId) {
        UserProblemSquare userProblemSquare = new UserProblemSquare();
        userProblemSquare.setUserId(userId);
        userProblemSquare.setProblemSquareId(problemSquareId);

        return userProblemSquareMapper.cancelAttention(userProblemSquare);
    }

    public int searchUserAttention(int userId, int problemSquareId) {
        UserProblemSquare userProblemSquare = new UserProblemSquare();
        userProblemSquare.setUserId(userId);
        userProblemSquare.setProblemSquareId(problemSquareId);
        List<UserProblemSquare> userProblemSquares =userProblemSquareMapper.searchUserAttention(userProblemSquare);
        if (userProblemSquares!= null && userProblemSquares.size()>0){
            return 1;
        }else {
            return  0;
        }
    }
}
