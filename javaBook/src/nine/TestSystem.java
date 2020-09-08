package nine;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class TestSystem {
    public static void main(String[] args) throws Exception {
        //获取系统的所有环境变量
        Map<String , String> env = System.getenv();
        for(String name : env.keySet()){
            System.out.println(name + " ---> " + env.get( name ));
        }
        //获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        //获取所有的系统属性
        Properties props = System.getProperties();
        //将所有系统属性保存到 props.txt 文件中
        props.store( new FileOutputStream( "props.txt" ) , "SystemProperties" );
        //输出特定的系统属性
        System.out.println(System.getProperty( "os.name" ));
    }
}
