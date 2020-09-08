package nine.cn.tedu.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMatches {
    public static void main(String[] args) {
        String[] mails = {
                "kongyeeku@163.com",
                "kongyeeku@gmail.com",
                "ligang@crazyit.org",
                "wawa@abc.xxx"
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
        Pattern mailPattern = Pattern.compile( mailRegEx );
        Matcher matcher = null;

        for (String mail : mails){
            if(matcher == null){
                matcher = mailPattern.matcher( mail );
            }else{
                //将之前 matcher 对象中所包含的字符序列，替换
                //matcher 对象包含了很多东西，不仅仅只有字符序列
                matcher.reset(mail);
            }
            if(matcher.matches()){
                System.out.println(mail + "是一个有效的邮件地址");
            }else{
                System.out.println(mail + "不是一个有效的邮件地址");
            }
        }
    }
}
