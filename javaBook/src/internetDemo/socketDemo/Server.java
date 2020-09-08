package internetDemo.socketDemo;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        //创建一个 ServerSocket，用于监听客户端 Socket 的连接请求
        ServerSocket ss = new ServerSocket( 3000 );

        //采用不断接受来自客户端的请求
        while (true){
            //每当接收到客户端的 Socket 的请求，服务器也将对应产生一个 Socket
            Socket s = ss.accept();

            //将 Socket 对应的输出流包装成 PrintStream
            PrintStream ps = new PrintStream( s.getOutputStream() );

            //进行普通的 IO 操作
            ps.print( "您好，收到了服务器的新年祝福" );

            //关闭输出流，关闭 Socket
            ps.close();
            s.close();
        }
    }
}
