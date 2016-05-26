package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10 0010.
 */

@Controller
@RequestMapping("/userController")
public class UserController{

    @Autowired
    private UserService userService;


    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ModelAndView login(String loginName, String password,
                              HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            User user = userService.login(loginName, password);
            if (user != null && user.getId() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                map.put("result", Boolean.TRUE);
                map.put("message", "success");
                map.put("user",user);
                System.out.println("登录成功！！");
            } else {
                map.put("result", Boolean.FALSE);
                map.put("message", "用户名或密码填写错误！");
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public ModelAndView register(String loginName, String password,String username,
                              HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            if (userService.selectByLoginName(loginName) != null){
                map.put("result", Boolean.FALSE);
                map.put("message", "用户名已经被占用！");
            }else {
                User user = new User();
                user.setLoginName(loginName);
                user.setPassword(password);
                user.setUserName(username);
                int rs = userService.insertSelective(user);
                if (rs !=  0) {
                    user = userService.login(loginName,password);
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    map.put("result", Boolean.TRUE);
                    map.put("message", "success");
                    map.put("user",user);
                    System.out.println("注册成功！！");
                } else {
                    map.put("result", Boolean.FALSE);
                    map.put("message", "注册失败");
                }
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "执行出现出错！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    @RequestMapping(value="/userinfo",method = RequestMethod.POST)
    public ModelAndView userinfo(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
             HttpSession session =  request.getSession();
             User user = (User)session.getAttribute("user");
            if (user != null){
                map.put("result", Boolean.TRUE);
                map.put("user",user);
            }else{
                map.put("result", Boolean.FALSE);
                map.put("message", "用户未登录！");
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            map.put("message", "用户未登录！");
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    //用户退出
    @RequestMapping(value="/loginOut",method = RequestMethod.GET)
    public ModelAndView loginOut(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            HttpSession session =  request.getSession();
            session.removeAttribute("user");
            map.put("result",Boolean.TRUE);
           } catch (Exception e) {
            map.put("result",Boolean.FALSE);
            e.printStackTrace();

          } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
         }
    }

}
