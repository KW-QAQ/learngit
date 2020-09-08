package fifteen.lock;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {
    public static void main(String[] args) {
        //文件锁

        FileChannel fileChannel = null;

        try{
            //使用 FileOutputStream 获取 FileChannel
            fileChannel = new FileOutputStream( "a.txt" ).getChannel();

            //使用非阻塞式方式对指定文件加锁
            FileLock lock = fileChannel.tryLock();

            //程序暂停 5 s
            Thread.sleep( 5000 );

            //释放锁
            lock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileChannel != null){
                    fileChannel.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
