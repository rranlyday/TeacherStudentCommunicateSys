package controller;

import model.ProblemSquare;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.UserService;
import util.StringUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
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
    public ModelAndView login(String loginName, String password,Boolean rememberPwd,
                              HttpServletRequest request,HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = userService.login(loginName, password);
            if (user != null && user.getId() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (rememberPwd){
                    Cookie loginNameCookie = new Cookie("loginName",user.getLoginName());
                    Cookie pwdCookie = new Cookie("password",user.getPassword());
                    response.addCookie(loginNameCookie);
                    response.addCookie(pwdCookie);
                }
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

    @RequestMapping(value="/getLoginInfo",method = RequestMethod.POST)
    public ModelAndView getLoginInfo(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            Cookie []cookies = request.getCookies();
            String loginName = null;
            String password = null;
            if (cookies != null){
                for (Cookie cookie:cookies){
                    if ("loginName".equals(cookie.getName())){
                        loginName = cookie.getValue();
                    }
                    if ("password".equals(cookie.getName())){
                        password = cookie.getValue();
                    }
                }
            }
            map.put("loginName",loginName);
            map.put("password",password);
            map.put("result", Boolean.TRUE);
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
    @RequestMapping(value="/loginOut",method = RequestMethod.POST)
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

    //更改密码
    @RequestMapping(value="/updatePassword",method = RequestMethod.POST)
    public ModelAndView updatePassword(String password,String newPassword,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user =  (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            int rs = userService.updatePassword(userId,password,newPassword);
            if (rs>0){
                map.put("result",Boolean.TRUE);
            }else{
                map.put("result",Boolean.FALSE);
                if (rs == -2){
                    map.put("message","密码错误!");
                }
            }
        } catch (Exception e) {
            map.put("result",Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //更改用户信息
    @RequestMapping(value="/updateUserInfo",method = RequestMethod.POST)
    public ModelAndView updateUserInfo(String userName, Integer userType,String sex,
                                       String school,String major,String grade,String no,
                                       String tel,String email,@RequestParam("file") CommonsMultipartFile[] files,
                                       HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            User user =  (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            for (int modelAndView = 0; modelAndView < files.length; ++modelAndView) {
                if (!files[modelAndView].isEmpty()) {
                    try {
                        String userInco = "/picture/userPic/" + StringUtil.refileName() + files[modelAndView].getOriginalFilename();
                        FileOutputStream os = new FileOutputStream(StringUtil.getSysPath() + userInco);
                        ByteArrayInputStream in = (ByteArrayInputStream) files[modelAndView].getInputStream();

                        int b = 0;
                        while ((b = in.read()) != -1) {
                            os.write(b);
                        }
                        os.flush();
                        os.close();
                        in.close();
                        if (userService.updateUserInfo(userId,userName,userType,sex,school,
                                major,grade,no,tel,email,userInco)>0){
                            map.put("result",Boolean.TRUE);
                        }else{
                            map.put("result",Boolean.FALSE);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("上传出错");
                    }
                }
                break;
            }
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
