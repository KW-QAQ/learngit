package nine;

import java.io.IOException;

public class TestExec {
    public static void main(String[] args) throws IOException {
        Runtime rt = Runtime.getRuntime();
        //运行记事本程序
        //单独启动一条进程来运行操作系统的命令
//        rt.exec( "notepad.exe" );
        System.out.println(rt.hashCode());
    }
}
