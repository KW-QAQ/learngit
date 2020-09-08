package threadDemo.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

class ReaderThread extends Thread {
    private PipedReader pr;

    //用于包装管道流的 BufferReader 对象
    private BufferedReader br;

    public ReaderThread(){}
    public ReaderThread(PipedReader pr){
        this.pr = pr;
        this.br = new BufferedReader( pr );
    }

    public void run(){
        String buf = null;
        try{
            //逐行读取管道输入流中的内容
            while ((buf = br.readLine()) != null){
                System.out.println(buf);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(br != null){
                    br.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class WriterThread extends Thread{
    String[] books = new String[]{
            "Struts2权威指南",
            "ROR 敏捷开发指南",
            "基于 J2EE 的 AJAX 宝典",
            "枪来接啊多发点"
    };
    private PipedWriter pw;
    public WriterThread(){}
    public WriterThread(PipedWriter pw){
        this.pw = pw;
    }
    public void run(){
        try{
            //循环 100 次，向管道输出流中写入 100 个字符串
            for(int i = 0 ; i < 100 ; i++){
                pw.write( books[i % 4] + "\n" );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pw != null){
                    pw.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
public class PipedCommunicationTest{
    public static void main(String[] args) {
        PipedWriter pw = null;
        PipedReader pr = null;
        try{
            //分别创建两个独立的管道输出流，输入流
            pw = new PipedWriter(  );
            pr = new PipedReader(  );

            //连接管道输出流，输入流
            pw.connect( pr );

            //将连接好的管道流分别传入两个线程
            //就可以实现通信
            new WriterThread( pw ).start();
            new ReaderThread( pr ).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


