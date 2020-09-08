package nine.cn.tedu.international;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
    public static void main(String[] args) {
        //缓冲流
        BufferedReader br = null;
        try {
            //运行 javac 命令，获取运行该命令的子进程
            Process p = Runtime.getRuntime().exec( "javac" );
            //以 p 进场的错误流创建一个 BufferedReader 对象
            //这个错误流对本程序来说是个输入流，对于 p 进场来说，则是一个输出流
            br = new BufferedReader( new InputStreamReader( p.getErrorStream() ) );

            String buff = null;

            //采用循环方式读取 p 进场的错误输出
            while ((buff = br.readLine()) != null){
                System.out.println(buff);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

                try {
                    if(br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }
    }
}
