package controller;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import DTO.ProblemSquareDTO;
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
import service.ProblemSquareService;
import service.UserProblemSquareService;
import service.UserService;
import util.MathUtil;
import util.StringUtil;

@Controller("problemSquareController")
@RequestMapping("/problemSquareController")
public class ProblemSquareController {

    @Autowired
    ProblemSquareService problemSquareService;

    @Autowired
    UserService userService;

    @Autowired
    UserProblemSquareService userProblemSquareService;

    @RequestMapping(value = "/build", method = RequestMethod.POST)
    public ModelAndView build(@RequestParam("file") CommonsMultipartFile[] files, String problemSquareName, String problemSquareDescription, HttpServletRequest request) {
        try {
            for (int modelAndView = 0; modelAndView < files.length; ++modelAndView) {
                System.out.println("fileName---------->" + files[modelAndView].getOriginalFilename());
                if (!files[modelAndView].isEmpty()) {
                    int pre = (int) System.currentTimeMillis();
                    try {
                        String photoPath = "/picture/psPic/" + StringUtil.refileName() + files[modelAndView].getOriginalFilename();
                        System.out.println(photoPath);
                        FileOutputStream os = new FileOutputStream(StringUtil.getSysPath() + photoPath);
                        ByteArrayInputStream in = (ByteArrayInputStream) files[modelAndView].getInputStream();

                        int b = 0;
                        while ((b = in.read()) != -1) {
                            os.write(b);
                        }
                        os.flush();
                        os.close();
                        in.close();
                        int finaltime = (int) System.currentTimeMillis();
                        System.out.println(finaltime - pre);
                        ProblemSquare problemSquare = new ProblemSquare();
                        problemSquare.setProblemSquareName(problemSquareName);
                        problemSquare.setProblemSquareDescription(problemSquareDescription);
                        problemSquare.setProblemSquareIcon(photoPath);
                        HttpSession session = request.getSession();
                        User user = (User) session.getAttribute("user");
                        problemSquare.setOwnerId(user.getId());
                        problemSquareService.bulidProblemSquare(problemSquare);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("上传出错");
                    }
                }
            }
        } finally {
            ModelAndView modelAndView1 = new ModelAndView("/html/index");
            return modelAndView1;
        }
    }

    @RequestMapping(value = "/getProblemSquare", method = RequestMethod.POST)
    public ModelAndView getProblemSquare(Integer pageNum, Integer pageSize, String condition) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        System.out.println("I am coming!!");
        try {
            List<ProblemSquare> problemSquareList = problemSquareService.selectProblemSquareOrderByTime(pageNum,pageSize,condition);
            List<ProblemSquareDTO> problemSquareDTOList = new ArrayList<ProblemSquareDTO>();
            for (int i = 0 ;i<problemSquareList.size();i++){
                ProblemSquare problemSquare = problemSquareList.get(i);
                Integer userId = problemSquare.getOwnerId();
                if (userId != null){
                    User user = userService.selectById(userId);
                    ProblemSquareDTO problemSquareDTO = new ProblemSquareDTO();
                    problemSquareDTO.setUser(user);
                    problemSquareDTO.setProblemSquare(problemSquare);
                    problemSquareDTOList.add(problemSquareDTO);
                }
            }
            int problemSquareTotal = problemSquareService.selectProblemSquareCount();
            int pageTotal = MathUtil.numToPageTotal(problemSquareTotal, pageSize);
            map.put("result", Boolean.TRUE);
            map.put("problemSquareDTOList",problemSquareDTOList);
            map.put("pageTotal",pageTotal);
            System.out.println("problemSquareDTOList: " + problemSquareDTOList.size());
        } catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }


    @RequestMapping(value = "/attentionProblemSquare", method = RequestMethod.POST)
    public ModelAndView attentionProblemSquare(Integer problemSquareId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        HashMap map = new HashMap();
        try {
            int userId = ((User) (request.getSession().getAttribute("user"))).getId();
            if (userProblemSquareService.addAttention(userId, problemSquareId) > 0) {   //关注
                map.put("result", Boolean.TRUE);
            } else {
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

    @RequestMapping(value = "/cancleAttentionProblemSquare", method = RequestMethod.POST)
    public ModelAndView cancleAttentionProblemSquare(Integer problemSquareId, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        HashMap map = new HashMap();
        try {
            int userId = ((User) (request.getSession().getAttribute("user"))).getId();
            if (userProblemSquareService.cancelAttention(userId, problemSquareId) > 0) {  //取消关注
                map.put("result", Boolean.TRUE);
            } else {
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

    @RequestMapping(value = "/addQuestionNum", method = RequestMethod.POST)
    public ModelAndView addQuestionNum(Integer problemSquareId, Integer questionNum) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        HashMap map = new HashMap();
        try {
            if (problemSquareService.addQuestionNum(problemSquareId,questionNum)>0);
            map.put("result", Boolean.TRUE);
        }catch (Exception e) {
            map.put("result", Boolean.FALSE);
            e.printStackTrace();
        } finally {
            view.setAttributesMap(map);
            mav.setView(view);
            return mav;
        }
    }
}
