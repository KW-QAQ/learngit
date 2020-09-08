package internetDemo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
    public static void main(String[] args) throws Exception {
        //将普通字符串转为
        //application/x-www-form-urlencoded 字符串
        String urlStr = URLEncoder.encode( "你好" , "UTF-8" );
        System.out.println(urlStr);

        //将 application/x-www-form-urlencoded 字符串
        //转换为普通字符串
        String keyWord = URLDecoder.decode( "%E4%BD%A0%E5%A5%BD","UTF-8" );
        System.out.println(keyWord);


    }
}
