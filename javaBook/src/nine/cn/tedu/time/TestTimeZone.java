package nine.cn.tedu.time;

import java.util.Arrays;
import java.util.TimeZone;

public class TestTimeZone {
    public static void main(String[] args) {
        //取得 Java 所支持的所有时区 ID
        String[] ids = TimeZone.getAvailableIDs();
        System.out.println();

        //从源码中可以看见，是对String 数组的一个拆分
        //进行一个遍历，再挨个整合到字符串中
        System.out.println( Arrays.toString(ids));

        //时区对象
        TimeZone my = TimeZone.getDefault();
        //获取系统默认时区
        System.out.println(my.getDisplayName());
        System.out.println(my.getID());

        //获取指定 ID 的时区的名称：纽芬兰标准时间
        System.out.println(TimeZone.getTimeZone( "CNT" ).getDisplayName());
    }
}
