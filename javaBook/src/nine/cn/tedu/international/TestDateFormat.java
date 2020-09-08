package nine.cn.tedu.international;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TestDateFormat {
    public static void main(String[] args) {
        //需要被格式化的时间
        Date dt = new Date(  );
        //创建两个 Locale，分别代表中国，美国
        Locale[] locales = {Locale.CHINA , Locale.US};
        DateFormat[] df = new DateFormat[16];

        //为上面两个创建 16 个 DateFormat 对象
        for(int i = 0 ; i < locales.length ; i++){
            df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT , locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM , locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG , locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL , locales[i]);
            df[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT , locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM , locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG , locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL , locales[i]);
        }
        for(int i = 0 ; i < locales.length ; i++){
            System.out.println("SHORT格式的日期格式：" + df[i * 8 ].format( dt ));
            System.out.println("MEDIUM格式的日期格式：" + df[i * 8 + 1].format( dt ));
            System.out.println("LONG格式的日期格式：" + df[i * 8 + 2].format( dt ));
            System.out.println("FULL格式的日期格式：" + df[i * 8 + 3].format( dt ));
            System.out.println("SHORT格式的日期格式：" + df[i * 8 + 4].format( dt ));
            System.out.println("MEDIUM格式的日期格式：" + df[i * 8 + 5].format( dt ));
            System.out.println("LONG格式的日期格式：" + df[i * 8 + 6].format( dt ));
            System.out.println("FULL格式的日期格式：" + df[i * 8 + 7].format( dt ));
        }
    }
}
