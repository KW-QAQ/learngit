package internetDemo.socketDemo.addThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {
    //该线程负责处理的 Socket
    private Socket s;

    //该线程所处理的 Socket 所对应的输入流
    BufferedReader br = null;

    public ClientThread(Socket s) throws Exception{
        this.s = s;
        br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
    }

    @Override
    public void run() {
        try {
            String content = null;

            //不断读取 Socket 输入流中的内容，将这些内容打印输出
            while ((content = br.readLine()) != null){
                System.out.println(content);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
