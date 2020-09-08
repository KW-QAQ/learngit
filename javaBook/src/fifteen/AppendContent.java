package fifteen;

import java.io.RandomAccessFile;

public class AppendContent {
    public static void main(String[] args) {
        RandomAccessFile raf = null;
        try {
            //以读、写方式打开一个 RandomAccessFile 对象
            raf = new RandomAccessFile( "props.txt" , "rw" );

            System.out.println(raf.length());
            //将记录指针移到文件的最后
            raf.seek( raf.length() );
            raf.write( "追加的内容！".getBytes() );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
