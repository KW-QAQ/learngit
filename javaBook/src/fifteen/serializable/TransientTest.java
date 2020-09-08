package fifteen.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
    public static void main(String[] args) {
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        try{
            //创建一个 ObjectOutputStream 输出流
            oos = new ObjectOutputStream( new FileOutputStream( "transient.txt" ) );
            Person per = new Person( "孙悟空" , 500 );
            //系统会 per 对象转换字节序列并输出
            oos.writeObject( per );

            //创建一个 ObjectInputStream 输入流
            ois = new ObjectInputStream( new FileInputStream( "transient.txt" ) );
            Person p1 = (Person) ois.readObject();
            System.out.println(p1.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
