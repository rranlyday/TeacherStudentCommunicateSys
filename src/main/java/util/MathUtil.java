package util;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MathUtil {


    public  static  int numToPageTotal(int num,int perPageSzie ){
        if (perPageSzie == 0){
            throw new RuntimeException("除数不能为0");
        }
        return  num/perPageSzie + (num%perPageSzie) == 0 ? 0:1;
    }
}
