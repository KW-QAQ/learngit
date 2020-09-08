package internetDemo.urlDemo;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

public class MutilDown {
    public static void main(String[] args) {
        //定义使用的线程数量
        final int DOWN_THREAD_NUM = 4;

        //文件流输出名称
        final String OUT_FILE_NAME = "down.jpg";

        InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
        RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];

        try {
            //创建一个 URL 对象
            URL url = new URL( "http://images.china-pub.com/ebook35001-40000/35850/shupi.jpg" );

            //以此 URL对象打开第一个输入流
            isArr[0] = url.openStream();
            long fileLen = getFileLength( url );
            System.out.println("网络资源的大小：" + fileLen);

            //以输出文件名创建第一个 RandomAccessFile 输出流
            outArr[0] = new RandomAccessFile( OUT_FILE_NAME , "rw" );

            //创建一个与下载资源相同大小的空文件
            for(int i = 0 ; i < fileLen ; i++){
                outArr[0].write( 0 );
            }

            //每线程应该下载的字节数
            long numPerThred = fileLen / DOWN_THREAD_NUM;

            //整个下载资源整除后剩下的余数
            long left = fileLen % DOWN_THREAD_NUM;

            for (int i = 0; i < DOWN_THREAD_NUM; i++) {
                //为每隔线程打开一个输入流，一个 RandomAccessFile 对象
                //让每隔线程分别负责下载资源的不同部分。
                if(i != 0){
                    //以 URL 打开多个输入流
                    isArr[i] = url.openStream();
                    //以指定输出文件创建多个 RandomAccessFile 对象
                    outArr[i] = new RandomAccessFile( OUT_FILE_NAME , "rw" );

                }

                //分别启动多个线程来下载网络资源
                if(i == DOWN_THREAD_NUM -1){
                    //最后一个线程下载地址的 NumPerThred + left 个字节
                    new DownThread( i * numPerThred , (i + 1) * numPerThred + left,
                            isArr[i] , outArr[i]).start();
                }else{
                    //每个线程负责下载一定的 numPerThred 个字节
                    new DownThread( i * numPerThred , (i + 1) * numPerThred,
                            isArr[i] , outArr[i]).start();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //定义获取指定网络资源的长度的方法
    public static long getFileLength(URL url) throws Exception{
        long length = 0;
        //打开该 URL 对应的 URLConnection。
        URLConnection con = url.openConnection();

        //获取连接 URL 资源的长度
        long size = con.getContentLength();
        length = size;
        return length;
    }
}
