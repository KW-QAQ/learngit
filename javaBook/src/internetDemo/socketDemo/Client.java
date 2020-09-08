package internetDemo.socketDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket( "127.0.0.1" , 3000 );


        //将 Socket 对应的输入流包装成  BufferedReader
        BufferedReader br = new BufferedReader( new InputStreamReader(  socket.getInputStream() ) );

        //进行普通的 IO 操作
        String line = br.readLine();
        System.out.println("来自服务器的数据：" + line);

        //关闭输入流、socket
        br.close();
        socket.close();
    }
}
