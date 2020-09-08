package fifteen.decode;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetTransform {
    public static void main(String[] args) throws CharacterCodingException {
        //创建简单的中文字符集
        Charset cn = Charset.forName( "GBK" );
        //获取 cn 对象对应的编码器和解码器
        CharsetEncoder charsetEncoder = cn.newEncoder();
        CharsetDecoder charsetDecoder = cn.newDecoder();

        //创建一个 CharBuffer 对象
        CharBuffer charBuffer = CharBuffer.allocate( 8 );

        charBuffer.put( '孙' );
        charBuffer.put( '悟' );
        charBuffer.put( '空' );

        charBuffer.flip();

        //将 charbuff 中的字符序列，转为字节序列
        ByteBuffer byteBuffer = charsetEncoder.encode( charBuffer );

        //循环访问 ByteBuffer 中的每一个字节
        for(int i = 0 ; i < byteBuffer.capacity() ; i++){
            System.out.println(byteBuffer.get(i) + " ");
        }
        //将 ByteBuffer 中的数据解码成字符序列
        System.out.println(charsetDecoder.decode( byteBuffer ));
    }
}
