package fifteen.nio;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args) {
        //创建 Buffer
        CharBuffer buff = CharBuffer.allocate( 8 );

        System.out.println("capacity:"+buff.capacity());
        System.out.println("limit:"+buff.limit());
        System.out.println("position:"+buff.position());

        //放入元素
        buff.put( 'a' );
        buff.put( 'b' );
        buff.put( 'c' );

        System.out.println("加入三个元素后，position = "+buff.position());
        System.out.println("加入三个元素后，limit = "+buff.limit());

        //调用 flip 方法，将 limit 变为 position，position 变为 0
        buff.flip();
        System.out.println("执行 flip() 后，limit = "+buff.limit());
        System.out.println("执行 flip() 后，position = "+buff.position());

        //去除第一个元素
        System.out.println("第一个元素："+buff.get());
        System.out.println("取出一个元素后，position = " + buff.position());

        //调用 clear 方法
        buff.clear();
        System.out.println("执行 clear() 后，limit = " + buff.limit());
        System.out.println("执行 clear() 后，position = " + buff.position());
        System.out.println("执行 clear() 后，缓冲区内容并没有消失；" + buff.get(2));
        System.out.println("执行绝对读取后，position = " + buff.position());
    }
}
