package controller;

import DTO.QuestionReplyDTO;
import model.QuestionReply;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.QuestionReplyService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
@Controller
@RequestMapping("/questionReplyController")
public class QuestionReplyController {

    @Autowired
    QuestionReplyService questionReplyService;

    @Autowired
    UserService userService;

    //添加回答
    @RequestMapping(value="/addQuestionReply",method = RequestMethod.POST)
    public ModelAndView addQuestionReply(Integer questionId,String replyDescription,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();

        try {
            User user  = (User)request.getSession().getAttribute("user");
            Integer responderId = user.getId();
            if (questionReplyService.addQuestionReply(questionId,responderId,replyDescription) > 0){
                map.put("result",Boolean.TRUE);
            }else{
                map.put("result",Boolean.FALSE);
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

    //删除回答
    @RequestMapping(value="/deleteQuestionReply",method = RequestMethod.POST)
    public ModelAndView deleteQuestionReply(Integer questionReplyId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (questionReplyService.deleteQuestionReply(questionReplyId) > 0) {
                map.put("result",Boolean.TRUE);
            }else{
                map.put("result",Boolean.FALSE);
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

    //点赞回答
    @RequestMapping(value="/addProNum",method = RequestMethod.POST)
    public ModelAndView addProNum(Integer questionReplyId,Integer num) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (questionReplyService.addProNum(questionReplyId, num) > 0) {
                map.put("result",Boolean.TRUE);
            }else{
                map.put("result",Boolean.FALSE);
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

    //反对回答
    @RequestMapping(value="/addInverseNum",method = RequestMethod.POST)
    public ModelAndView addInverseNum(Integer questionReplyId,Integer num) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (questionReplyService.addInverseNum(questionReplyId, num) > 0) {
                map.put("result",Boolean.TRUE);
            }else{
                map.put("result",Boolean.FALSE);
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

    //获取问题的回答数量
    @RequestMapping(value="/getPageNum",method = RequestMethod.POST)
    public ModelAndView getPageNum(Integer questionReplyId,Integer pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            int pageNum = questionReplyService.getPageNum(questionReplyId,pageSize);
            map.put("pageNum",pageNum);
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

    //根据时间查询回答
    @RequestMapping(value="/searchByTime",method = RequestMethod.POST)
    public ModelAndView searchByTime(Integer questionId,Integer curPage,Integer pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<QuestionReply> questionReplyList =
                    questionReplyService.searchQuestionReplyByQuestionIdOrderByTime(questionId,curPage,pageSize);
            List<QuestionReplyDTO> questionReplyDTOList = new ArrayList<QuestionReplyDTO>();
            for (QuestionReply questionReply:questionReplyList){
                User user = userService.selectById(questionReply.getResponderId());
                QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();
                questionReplyDTO.setUser(user);
                questionReplyDTO.setQuestionReply(questionReply);
                questionReplyDTOList.add(questionReplyDTO);
            }
            map.put("questionReplyDTOList",questionReplyDTOList);
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

    //根据采纳率查询回答
    @RequestMapping(value="/searchByAdoptionRate",method = RequestMethod.POST)
    public ModelAndView searchByAdoptionRate(Integer questionId,Integer curPage,Integer pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<QuestionReply> questionReplyList =
                    questionReplyService.searchQuestionReplyByQuestionIdOrderByAdoptionRate(questionId,curPage,pageSize);
            List<QuestionReplyDTO> questionReplyDTOList = new ArrayList<QuestionReplyDTO>();
            for (QuestionReply questionReply:questionReplyList){
                User user = userService.selectById(questionReply.getResponderId());
                QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();
                questionReplyDTO.setUser(user);
                questionReplyDTO.setQuestionReply(questionReply);
                questionReplyDTOList.add(questionReplyDTO);
            }
            map.put("questionReplyDTOList",questionReplyDTOList);
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
