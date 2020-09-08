package nine.cn.tedu.time;

import java.util.Calendar;

public class TestLazy {
    public static void main(String[] args) {

        //set 具有延迟修改机制
        //刚开始改变字段的话，就只改变字段，不会讲其他进行一个计算
        //只遇到，get，getTime，add，roll 等需要进行时间计算的时候，才会统一计算
        Calendar cal = Calendar.getInstance();
        cal.set( 2003 , 7, 31 );
        cal.set( Calendar.MONTH , 8 );
//        System.out.println(cal.getTime());
        cal.set( Calendar.DATE , 5 );
        System.out.println(cal.getTime());

    }
}
