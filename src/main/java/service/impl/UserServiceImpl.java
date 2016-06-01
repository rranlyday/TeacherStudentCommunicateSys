package service.impl;

import dao.UserMapper;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;




/**
 * Created by Administrator on 2016/5/10 0010.
 */

@Service("userService")
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    public User login(String loginName, String password) {
        User user = new User();
        user.setLoginName(loginName);
        user.setPassword(password);

        return userMapper.login(user);
    }

    public int insertSelective(User user) {
        if (user != null){
            int  returnId  = userMapper.insertSelective(user);
            return  user.getId();
        }
        return  -1;        //≤Â»Î ß∞‹
    }

    public User selectByLoginName(String loginname) {
        try {
            return userMapper.selectByLoginName(loginname);
        }catch (Exception e){
            return  null;
        }
    }

    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int updatePassword(Integer userId, String password, String newPassword) {
        if (password == null || password.equals(""))
            return  -1;
        User user = userMapper.selectByPrimaryKey(userId);
        if (password.equals(user.getPassword())){
            user.setPassword(newPassword);
            return userMapper.updateByPrimaryKey(user);
        }else{
            return  -2;
        }
    }

    public int updateUserInfo(Integer userId, String userName, Integer userType,
                              String sex, String school, String major, String grade,
                              String no, String tel, String email, String userInco) {
        User user = new User();
        user.setId(userId);
        user.setUserName(userName);
        user.setUserType(userType);
        user.setSex(sex);
        user.setSchool(school);
        user.setMajor(major);
        user.setGrade(grade);
        user.setNo(no);
        user.setTel(tel);
        user.setEmail(email);
        user.setUserInco(userInco);

        return userMapper.updateByPrimaryKeySelective(user);
    }
}
