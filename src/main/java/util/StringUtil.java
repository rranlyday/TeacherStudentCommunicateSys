package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class StringUtil {
    public  static  String refileName(){
        Long time = new Date().getTime();
        return  time.toString();
    }

    public static  String getSysPath(){
        String path =  "D:/myproject/TeacherStudentCommunicateSys/src/main/webapp";
        return  path;
    }

    public static  String  manyPicAdressToOne(List<String> pathList,String separator){
        if (pathList.isEmpty())
            return  null;
        String path = pathList.get(0) ;  //获取第一个
        for (int i = 1 ;i<pathList.size();i++){  //从第二个开始
            path += separator +pathList.get(i);
        }
        return  path;
    }

    public  static  List<String> onePicAdressToMany(String path,String regex){
        if (path==null || path.equals(""))
            return  null;
        String[] pathArgs = path.split(regex);
        List<String> pathList = new ArrayList<String>();
        for (String val : pathArgs){
            pathList.add(val);
        }
        return  pathList;
    }
}
