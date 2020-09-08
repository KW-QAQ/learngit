package fifteen.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try{

            //创建一个 ObjectOutputStream 输出流
            oos = new ObjectOutputStream( new FileOutputStream( "replace.txt" ) );
            Person per = new Person( "孙悟空" , 50 );

            //系统将 per 对象转换字节序列并输出
            oos.writeObject( per );

            //创建一个 ObjectInputStream 输入流
            ois = new ObjectInputStream( new FileInputStream( "replace.txt" ) );
//            ArrayList list = (ArrayList) ois.readObject();
//            System.out.println(list);
            System.out.println(ois);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
