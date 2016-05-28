package controller;

import model.Material;
import model.ProblemSquare;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;
import service.MaterialService;
import util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/26 0026.
 */
@Controller
@RequestMapping("/materialController")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    //上传资料
    @RequestMapping(value="/uploadMaterial",method = RequestMethod.POST)
    public ModelAndView uploadMaterial(@RequestParam("file") CommonsMultipartFile[] files, Integer problemSquareId,
                                       String materialName,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            User user = (User)request.getSession().getAttribute("user");
            int userId = user.getId();
            List<String> filePathList = new ArrayList<String>();
            for (int modelAndView = 0; modelAndView < files.length; ++modelAndView) {
                System.out.println("fileName---------->" + files[modelAndView].getOriginalFilename());
                if (!files[modelAndView].isEmpty()) {
                    int pre = (int) System.currentTimeMillis();
                    try {
                        String filePath = "/material/" + StringUtil.refileName() + files[modelAndView].getOriginalFilename();
                        System.out.println(filePath);
                        FileOutputStream os = new FileOutputStream(StringUtil.getSysPath() + filePath);
                        ByteArrayInputStream in = (ByteArrayInputStream) files[modelAndView].getInputStream();

                        int b = 0;
                        while ((b = in.read()) != -1) {
                            os.write(b);
                        }
                        os.flush();
                        os.close();
                        in.close();
                        int finaltime = (int) System.currentTimeMillis();
                        filePathList.add(filePath);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("上传出错");
                        throw  new Exception(e);
                    }
                }
            }
            String storageAddress = StringUtil.manyPicAdressToOne(filePathList,";");
            if(materialService.uploadMaterial(userId,problemSquareId,materialName,storageAddress) > 0){
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



    //删除资料
    @RequestMapping(value="/deleteMaterial",method = RequestMethod.POST)
    public ModelAndView deleteMaterial(Integer materialId,HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            if (materialService.deleteMaterial(materialId) > 0){
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

    //查询作业
    @RequestMapping(value="/searchMaterial",method = RequestMethod.POST)
    public ModelAndView searchMaterial(Integer problemSquareId,Integer curPage,Integer pageSize) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            List<Material> materialList = materialService.searchMaterialByProblemSquareId(problemSquareId,curPage,pageSize);
            map.put("materialList",materialList);
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

    //查询作业ById
    @RequestMapping(value="/searchMaterialById",method = RequestMethod.POST)
    public ModelAndView searchMaterialById(Integer materialId) {
        ModelAndView mav = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        Map map = new HashMap();
        try {
            Material material = materialService.searchMaterialById(materialId);
            map.put("material",material);
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
