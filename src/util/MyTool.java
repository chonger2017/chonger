package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/27.
 */
public class MyTool {
    public static String getRandomEmpid(){
        Random random=new Random();
        int i1=random.nextInt(9);
        int i2=random.nextInt(9);
        int i3=random.nextInt(9);
        Date date=new Date();
        String str=date.getTime()+"";
        return str+i1+i2+i3;

    }

    public static void main(String[] args) {
        System.out.print(getRandomEmpid());
    }
}
