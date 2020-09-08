package nine.cn.tedu.time;

import java.util.Date;

public class TestDate {
    public static void main(String[] args) {
        Date d1 = new Date(  );
        //获取当前时间之后 100ms 的时间
        System.out.println(System.currentTimeMillis());
        Date d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println("d2:" + d2);
        System.out.println("d1:" + d1);
        System.out.println(d1.compareTo( d2 ));
        System.out.println(d1.equals( d2 ));
        System.out.println(d1.before( d2 ));

    }

}
