package nine.cn.tedu.time;

import java.util.Calendar;

public class TestCalendar {
    public static void main(String[] args) {
        //Calendar 是一个抽象类，不能直接实例化，但是可以通过静态方法来实例化
        Calendar c = Calendar.getInstance();

        System.out.println(c.getTime());

        //取出年，月，日
        System.out.println(c.get( Calendar.YEAR ));
        System.out.println(c.get( Calendar.MONTH ));
        System.out.println(c.get( Calendar.DATE ));

        //分别设置年，月，日，时，分，秒
        c.set( 2000 , 0 , 1 , 10 , 12 , 12 );

        System.out.println(c.getTime());

        //将 Calendar 的年前推 1 年
//        c.add( Calendar.YEAR , -1 );
//        System.out.println(c.getTime());

        //将 Calendar 的月前腿 2 月
        c.roll( Calendar.MONTH , 13 );
//        System.out.println(c.getTime());

//        c.add( Calendar.MONTH , 13);
        System.out.println(c.getTime());


    }
}
