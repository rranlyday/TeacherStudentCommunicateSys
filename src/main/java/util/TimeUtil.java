package util;

import java.util.Date;

/**
 * Created by Administrator on 2016/5/22 0022.
 */
public class TimeUtil {
    public  static Date getNowSysTime(){
        Date date = new Date();
        return  date;
    }

    public static void  main(String[] args){
        System.out.println(TimeUtil.getNowSysTime());
    }
}
