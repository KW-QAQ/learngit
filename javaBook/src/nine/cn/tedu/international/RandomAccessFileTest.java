package nine.cn.tedu.international;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            //以只读的形式打开一个 RandomAccessFile 对象
            raf = new RandomAccessFile( "props.txt" , "r" );

            //获取 RandomAccessFile 对象文件指针的位置，初始位置是 0
            System.out.println("RandomAccessFile 的文件指针的初始位置："
            +raf.getFilePointer());

            //移动 raf 的文件记录指针的位置
            raf.seek( 0 );
            byte[] bbuf = new byte[1024];

            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环来重复 “取水” 的过程
            while ((hasRead = raf.read(bbuf)) != 0){
                System.out.println(hasRead);
                System.out.println(new String( bbuf , 0 , hasRead ));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(raf != null){
                    raf.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
