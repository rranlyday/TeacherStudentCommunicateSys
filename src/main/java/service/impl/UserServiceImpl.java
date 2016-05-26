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
}
