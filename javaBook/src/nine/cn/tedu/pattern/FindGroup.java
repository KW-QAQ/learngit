package nine.cn.tedu.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindGroup {
    public static void main(String[] args) {
        //创建一个 pattern 对象，并用它建立一个 Matcher 对象
        Pattern a = Pattern.compile( "\\w+" );
        Matcher m = a.matcher( "Java is not very easy!" );

        while (m.find()){
            System.out.println(m.group());
        }
        int i = 0;
        while (m.find(i)){
            System.out.println(m.group() + "\t");
            i++;
        }
    }
}
