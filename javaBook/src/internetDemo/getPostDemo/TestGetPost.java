package internetDemo.getPostDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class TestGetPost {

    public static void main(String[] args) {
        //发送 get 请求
        String s = TestGetPost.sendGet( "http://localhost:8888/abc/login.jsp" , null );

        System.out.println(s);

        //发送 POST 请求
        String s1 = TestGetPost.sendPost( "http://localhost:8888/abc/login.jsp" , "user=李刚&pass=abc");
        System.out.println(s1);
    }

    /**
     * 向指定 URL 发送 GET 方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name=value&name2=value2 的形式
     * @return URL 所代表远程资源的响应
     */
    public static String sendGet(String url , String param){
        String result = "";
        BufferedReader in = null;
        try {
            String urlName = url + "?" + param;
            URL realUrl = new URL( urlName );

            //打开和 URL 直接的连接
            URLConnection conn = realUrl.openConnection();

            //设置通用的请求属性
            conn.setRequestProperty( "accept" , "*/*" );
            conn.setRequestProperty( "connection" , "Keep-Alive" );
            conn.setRequestProperty( "user-agent" ,
                    "Mozilla/4.0 (compatible; MSIE 6.0 ; Windows NT 5.1; SV1)");

            //建立实际的连接（仅适用于 get）
            conn.connect();
            //获取所有响应头字段
            Map<String , List<String>> map = conn.getHeaderFields();

            //遍历所有响应头字段
            for(String key : map.keySet()){
                System.out.println(key + "--->" + map.get( key ));
            }

            //定义 BufferedReader 输入流来读取 URL 的响应
            in = new BufferedReader(
                    new InputStreamReader( conn.getInputStream() )
            );

            String line;
            while ((line = in.readLine()) != null){
                result += "\n" + line;
            }
        }catch (Exception e){
            System.out.println("发送 GET 请求出现异常!" + e);
            e.printStackTrace();
        }finally {
            try {

                    if(in != null){
                        in.close();
                    }
                }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送 POST 方法的请求
     * @param url 发送请求的 URL
     * @param param 请求参数，请求参数应该是 name=value&name2=value2 的形式
     * @return URL 所代表远程资源的响应
     */
    public static String sendPost(String url , String param){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";

        try {
            URL realUrl = new URL( url );

            //打开和 URL 之间的连接
            URLConnection conn = realUrl.openConnection();

            //设置通用的请求属性
            conn.setRequestProperty( "accept" , "*/*" );
            conn.setRequestProperty( "connection" , "Keep-Alive" );
            conn.setRequestProperty( "user-agent" ,
                    "Mozilla/4.0 (compatible; MSIE 6.0 ; Windows NT 5.1; SV1)");

            //发送 POST 请求必须设置如下两行
            conn.setDoInput( true );
            conn.setDoOutput( true );

            //获取 URLConnection 对象对应的输出流，用于向 URLConnection 发送请求
            out = new PrintWriter( conn.getOutputStream() );

            //发送请求参数
            out.print(param);

            //flush 输出流的缓冲
            out.flush();

            //定义 BufferedReader 输入流来读取 URL 的响应
            in = new BufferedReader(
                    new InputStreamReader( conn.getInputStream() )
            );
            String line;
            while ((line = in.readLine()) != null){
                result += "\n" + line;
            }
        }catch (Exception e){
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }finally {
            try {
                if(out != null){
                    out.close();
                }if(in != null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
