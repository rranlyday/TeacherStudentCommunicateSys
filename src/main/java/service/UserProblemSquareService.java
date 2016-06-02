package service;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
public interface UserProblemSquareService {

    int addAttention(int userId,int problemSquareId);

    int cancelAttention(int userId,int problemSquareId);

    int searchUserAttention(int userId,int problemSquareId);
}
