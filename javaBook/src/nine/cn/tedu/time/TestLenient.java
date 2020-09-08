package nine.cn.tedu.time;

import java.util.Calendar;

//Calendar 的容错率
public class TestLenient {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

//        cal.set( Calendar.MONTH , 13 );
//        System.out.println(cal.getTime());

        //关闭容错性
        cal.setLenient( false );

        //导致运行时异常
        cal.set(Calendar.MONTH , 13);
        System.out.println(cal.getTime());
    }
}
