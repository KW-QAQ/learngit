package fifteen.serializable;

import java.io.*;

public class SerializeMutable {
    public static void main(String[] args) throws IOException {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try{
            //创建一个 ObjectOutputStream 输入流
            oos = new ObjectOutputStream(
                    new FileOutputStream( "mutable.txt" )
            );
            Person per = new Person( "孙悟空" , 500 );
            //系统将 per 转为字节序列输出
            oos.writeObject( per );

            //改变 per 的 name 属性值
            per.setName( "猪八戒" );

            //系统只是输出序列号编号，所以改变后的 name 不会被序列化
            oos.writeObject( per );

            //创建一个 ObjectInputStream 输入流
            ois = new ObjectInputStream( new FileInputStream( "mutable.txt" ) );
            Person p1 = (Person) ois.readObject();
            Person p2 = (Person) ois.readObject();
            System.out.println(p1.getName());
            System.out.println(p2.getName());

            //改变 per 的
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ois != null){
                ois.close();
            }
            if(oos != null){
                oos.close();
            }
        }
    }
}
