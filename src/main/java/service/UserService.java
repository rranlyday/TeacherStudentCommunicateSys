package service;

import model.User;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public interface UserService {

     User login(String loginName,String password);

     int insertSelective(User user);

     User selectByLoginName(String loginname);

     User selectById(int id);

     int updatePassword(Integer userId,String password,String newPassword);

     int updateUserInfo(Integer userId,String userName, Integer userType,String sex,
                        String school,String major,String grade,String no,
                        String tel,String email,String userInco);
}
