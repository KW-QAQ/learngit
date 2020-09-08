package fifteen.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{

            File f = new File("./src/fifteen/nio/FileChannelTest.java");
            //创建 FileInputStream , 以该文件输入流创建 FileChannel
            inChannel = new FileInputStream( f ).getChannel();

            //将 FileChannel 里的全部数据映射成为 ByteBuffer
            MappedByteBuffer buffer = inChannel.map( FileChannel.MapMode.READ_ONLY , 0 ,f.length() );

            //使用 GBK 的字符集来创建解码器
            Charset charset = Charset.forName( "UTF-8" );
            //以文件输出流创建 FileBuffer，用以控制输出
            outChannel = new FileOutputStream( "a.txt" ).getChannel();

            //直接将 buffer 中的所有数据全部输出
            outChannel.write( buffer );

            //再次调用 buffer 重点 clear() 方法，复原 limit、position 的位置
            buffer.clear();

            //创建解码器 (CharsetDecoder)对象
            CharsetDecoder decoder = charset.newDecoder();

            //使用解码器将 ByteBuffer 转换为 CharBuffer
            CharBuffer charBuffer = decoder.decode( buffer );

            System.out.println(charBuffer);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
