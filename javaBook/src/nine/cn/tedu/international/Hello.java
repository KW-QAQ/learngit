package nine.cn.tedu.international;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {
    public static void main(String[] args) {
        //取得系统默认的国家 / 语言环境
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);

        //根据指定国家 / 语言环境 加载资源文件
        ResourceBundle bundle = ResourceBundle.getBundle( "mess" , myLocale );

        //打印从资源文件中取得的消息
        System.out.println(bundle.getString( "hello" ));
    }
}
