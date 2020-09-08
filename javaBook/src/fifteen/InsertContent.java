package fifteen;

import java.io.*;

public class InsertContent {
    public static void insert(String fileName , long pos,
                              String insertContent) throws IOException {
        RandomAccessFile raf = null;

        //创建一个临时文件来保存插入点后的数据
        File tmp = File.createTempFile( "tmp" , null );
        FileOutputStream tmpOut = null;
        FileInputStream tmpIn = null;

        //将删除命令，缓存，直到服务终止才执行
        tmp.deleteOnExit();

        try{
            raf = new RandomAccessFile( fileName , "rw" );
            tmpOut = new FileOutputStream( tmp );
            tmpIn = new FileInputStream( tmp );

            raf.seek( pos );

            //下面代码将插入点后的内容读入临时文件中保存
            byte[] bbuf = new byte[64];
            //用于保存实际读取的字节数
            int hasRead = 0;
            //使用循环方式进行读取插入点后的数据
            while( (hasRead = raf.read( bbuf )) > 0 ){
                //将读取的数据写入临时文件
                System.out.println(hasRead);

                //防止 bbuf 未满，导致空字节传入
                tmpOut.write( bbuf , 0 , hasRead );
//                tmpOut.write( bbuf );
            }

            //下面代码插入内容
            //把文件记录指针重新定位到pos位置
            raf.seek( pos );
            raf.write( insertContent.getBytes() );

            //追加临时文件中的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write( bbuf , 0 ,hasRead );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            raf.close();
        }
    }

    public static void main(String[] args) throws IOException {
        insert( "props.txt" , 10 , "\n尼玛这了尼玛这了尼玛这了尼玛这了尼玛这了\n" );
    }
}
