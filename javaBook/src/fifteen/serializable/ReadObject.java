package fifteen.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try {
            //创建一个 ObjectInputStream 输出流
            ois = new ObjectInputStream(
                    new FileInputStream( "object.txt" )
            );

            //从输入流中读取一个 Java 对象，并将其强制类型转为 Person 类
            Person p = (Person) ois.readObject();
            System.out.println("名字为：" + p.getName() +
                    "\n年龄为：" + p.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
