package controller;

import DTO.ReplyQuestionReplyDTO;
import model.ReplyQuestionReply;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.QuestionReplyService;
import service.ReplyQuestionReplyService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/27 0027.
 */
@Controller
@RequestMapping("/replyQuestionReplyController")
public class ReplyQuestionReplyController {

    @Autowired
    ReplyQuestionReplyService replyQuestionReplyService;

    @Autowired
    QuestionReplyService questionReplyService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/addReplyQuestionReply",method = RequestMethod.POST)
    public ModelAndView addReplyQuestionReply(Integer questionReplyId, String replyDescription,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int responderId = user.getId();
            if(replyQuestionReplyService.addReplyQuestionReply(questionReplyId,responderId,replyDescription)>0){
                questionReplyService.addReplyNum(questionReplyId,1);
                map.put("result", Boolean.TRUE);
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value="/deleteReplyQuestionReply",method = RequestMethod.POST)
    public ModelAndView deleteReplyQuestionReply(Integer replyQuestionReplyId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int responderId = user.getId();
            if(replyQuestionReplyService.deleteReplyQuestionReply(replyQuestionReplyId)>0){
                map.put("result", Boolean.TRUE);
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    @RequestMapping(value="/addProNum",method = RequestMethod.POST)
    public ModelAndView addProNum(Integer replyQuestionReplyId,Integer num) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if(replyQuestionReplyService.addProNum(replyQuestionReplyId, num)>0){
                map.put("result", Boolean.TRUE);
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value="/addInverseNum",method = RequestMethod.POST)
    public ModelAndView addInverseNum(Integer replyQuestionReplyId,Integer num) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if(replyQuestionReplyService.addInverseNum(replyQuestionReplyId, num)>0){
                map.put("result", Boolean.TRUE);
            }else{
                map.put("result", Boolean.FALSE);
            }
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }

    @RequestMapping(value="/searchReplyQuestionReplyOrderByTime",method = RequestMethod.POST)
    public ModelAndView searchReplyQuestionReplyOrderByTime(Integer questionReplyId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<ReplyQuestionReply> replyQuestionReplyList =
                    replyQuestionReplyService.searchReplyQuestionReplyOrderByTime(questionReplyId);

            List<ReplyQuestionReplyDTO> replyQuestionReplyDTOList = new ArrayList<ReplyQuestionReplyDTO>();
            for (ReplyQuestionReply replyQuestionReply :replyQuestionReplyList){
                User user = userService.selectById(replyQuestionReply.getResponderId());
                if (user != null){
                    ReplyQuestionReplyDTO replyQuestionReplyDTO = new ReplyQuestionReplyDTO();
                    replyQuestionReplyDTO.setUser(user);
                    replyQuestionReplyDTO.setReplyQuestionReply(replyQuestionReply);
                    replyQuestionReplyDTOList.add(replyQuestionReplyDTO);
                }
            }
            map.put("result", Boolean.TRUE);
            map.put("replyQuestionReplyDTOList",replyQuestionReplyDTOList);
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
