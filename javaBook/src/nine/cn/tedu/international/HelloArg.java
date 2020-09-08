package nine.cn.tedu.international;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloArg {
    public static void main(String[] args) {
        //定义一个 Locale 变量
        Locale currentLocale = null;
        //如果运行程序的指定了两个参数
        if(args.length == 2){
            //使用运行程序的两个参数构造 Locale 实例
            currentLocale = new Locale( args[0] , args[1] );

        }else{
            //否则直接使用系统默认的 Locale
            currentLocale = Locale.getDefault();
        }
        //根据 Locale 加载语言资源
        ResourceBundle bundle = ResourceBundle.getBundle( "MyResource" , currentLocale );
        //取得已加载的语言资源文件中的 msg 对应消息
        String msg = bundle.getString( "msg" );
        System.out.println(msg);
        //使用 MessageFormat 为带占位符的字符串传入参数
        System.out.println( MessageFormat.format( msg , "aaa" , new Date(  ) ) );
    }
}
