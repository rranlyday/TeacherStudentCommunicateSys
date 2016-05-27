package controller;

import DTO.QuestionDTO;
import model.Question;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.QuestionService;
import service.UserService;
import util.MathUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/25 0025.
 */
@Controller
@RequestMapping("/questionController")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    UserService userService;

    @RequestMapping(value="/searchQuestion",method = RequestMethod.POST)
    public ModelAndView searchQuestion(int problemSquareId,int curPage,int pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
            List<Question> questionList = questionService.searchQuestionOrderByTimeByProblemSquareId(problemSquareId,curPage,pageSize);
            for (Question question:questionList){
                User user = userService.selectById(question.getQuestionerId());
                if (user != null){
                    QuestionDTO questionDTO = new QuestionDTO();
                    questionDTO.setQuestion(question);
                    questionDTO.setUser(user);
                    questionDTOList.add(questionDTO);
                }
            }
            int questionTotal = questionService.searchQuestioNumByProblemSquareId(problemSquareId);
            int pageTotal = MathUtil.numToPageTotal(questionTotal, pageSize);

            map.put("questionDTOList",questionDTOList);
            map.put("result", Boolean.TRUE);
            map.put("pageTotal",pageTotal);
            map.put("message", "查询成功!");
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

    @RequestMapping(value="/buildQuestion",method = RequestMethod.POST)
    public ModelAndView buildQuestion(Integer problemSquareId,
                                      String questionTitle,String questionDescription,
                                      HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            Integer questionerId = user.getId();
            int rs = questionService.buildQuestion(questionerId,problemSquareId,questionTitle,questionDescription);
            if (rs > 0){
                map.put("result", Boolean.TRUE);
                map.put("message", "新建成功！");
            }
            else{
                map.put("result", Boolean.FALSE);
                map.put("message", "新建失败！");
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

    @RequestMapping(value="/deleteQuestion",method = RequestMethod.POST)
    public ModelAndView deleteQuestion(Integer questionId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            int rs = questionService.deleteQuestion(questionId);
            if (rs > 0){
                map.put("result", Boolean.TRUE);
                map.put("message", "删除成功！");
            }
            else{
                map.put("result", Boolean.FALSE);
                map.put("message", "删除失败！");
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
}
