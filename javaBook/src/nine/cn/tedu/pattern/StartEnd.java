package nine.cn.tedu.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartEnd {
    public static void main(String[] args) {
        //创建一个 Pattern 对象，用它建立一个 Matcher 对象
        String regStr = "Java is very easy";
        System.out.println("目标字符串：" + regStr);
        Pattern p = Pattern.compile( "\\w+" );
        Matcher m = p.matcher( regStr );
        while (m.find()){
            System.out.println(m.group() + "字符串的起始位置：" + m.start()
                    + "，其结束位置：" + m.end());
        }
    }
}
