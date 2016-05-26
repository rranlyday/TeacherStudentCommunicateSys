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

}
