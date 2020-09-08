package fifteen.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ReadFile {
    //用 Channel 读取的文件过大，多次读取，减少服务器性能压力
    public static void main(String[] args) {
        FileChannel fcin = null;
        try{
            //创建文件输入流
            FileInputStream fis = new FileInputStream( "./src/fifteen/nio/ReadFile.java" );

            //创建一个 FileChannel
            fcin = fis.getChannel();

            //定义一个 ByteBuffer 对象，用于重复取水
            ByteBuffer buffer = ByteBuffer.allocate( 1024 );

            //将 FileChannel 中数据放入 ByteBuffer 中
            while(fcin.read( buffer ) != -1){
                //锁定 Buffer 的空白区
                buffer.flip();
                //创建charset对象
                Charset charset = Charset.forName( "UTF-8" );
                //创建解码器
                CharsetDecoder decoder = charset.newDecoder();
                //将 ByteBuffer 的内容转码
                CharBuffer charBuffer = decoder.decode( buffer );
                System.out.println(charBuffer);
                buffer.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}
