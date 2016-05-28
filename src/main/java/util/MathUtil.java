package util;

/**
 * Created by Administrator on 2016/5/24 0024.
 */
public class MathUtil {


    public  static  int numToPageTotal(int num,int perPageSzie ){
        if (perPageSzie == 0){
            throw new RuntimeException("除数不能为0");
        }
        int count = num/perPageSzie;
        if (num%perPageSzie !=0)
            count++;
        return  count;
    }

    public static void main(String[] args){
        System.out.println(numToPageTotal(11,8));
    }
}
