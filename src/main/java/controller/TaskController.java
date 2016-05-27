package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.TaskService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Controller
@RequestMapping("/taskController")
public class TaskController {

    @Autowired
    TaskService taskService;

    //发布作业
    @RequestMapping(value="/buildTask",method = RequestMethod.POST)
    public ModelAndView buildTask(Integer problemSquareId, String taskTitle,
                                  String taskDecription,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            User user =  (User)request.getSession().getAttribute("user");
            int publisherId = user.getId();
            if (taskService.buildTask(publisherId,problemSquareId,taskTitle,taskDecription) > 0){
                map.put("result",Boolean.TRUE);
            }else {
                map.put("result",Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result",Boolean.TRUE);
            e.printStackTrace();

        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //删除作业
    @RequestMapping(value="/deleteTask",method = RequestMethod.GET)
    public ModelAndView deleteTask(int taskId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (taskService.deleteTaskById(taskId) > 0){
                map.put("result",Boolean.TRUE);
            }else {
                map.put("result",Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result",Boolean.TRUE);
            e.printStackTrace();

        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    //更改作业
    @RequestMapping(value="/updateTask",method = RequestMethod.GET)
    public ModelAndView updateTask(int taskId,String taskTitle, String taskDecription) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (taskService.updateTaskSelectiveById(taskId,taskTitle,taskDecription)>0){
                map.put("result",Boolean.TRUE);
            }else {
                map.put("result",Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result",Boolean.TRUE);
            e.printStackTrace();

        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
