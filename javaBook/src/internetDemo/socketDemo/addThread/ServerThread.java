package internetDemo.socketDemo.addThread;

import java.io.*;
import java.net.Socket;

//负责处理每个线程通信的线程类
public class ServerThread implements Runnable{
    //定义当前线程所处理的 Socket
    Socket s = null;

    //该线程所处理的 Socket 所对应的输入流
    BufferedReader br = null;
    public ServerThread(Socket s) throws IOException{
        this.s = s;

        //初始化该 socket 对应的输入流
        br = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
    }

    @Override
    public void run() {
        try{
            String content = null;

            //采用循环不断从 Socket 中读取客户端发送过来的数据
            while ((content = readFromClient()) != null){
                //遍历 SocketLIst 中的每个 socket
                //将督导的内容向每个 Socket 发送一次
                for(Socket socket : MyServer.socketList){
                    PrintStream ps = new PrintStream( new ObjectOutputStream( socket.getOutputStream() ) );
                    ps.println( content );
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //定义读取客户端数据的方法
    private String readFromClient(){
        try{
            return br.readLine();
        }catch (Exception e){
            //如果捕捉到异常，说明该 socket 对应的客户端已经关闭
            //删除该 Socket
            MyServer.socketList.remove( s );
        }
        return null;

    }
}
