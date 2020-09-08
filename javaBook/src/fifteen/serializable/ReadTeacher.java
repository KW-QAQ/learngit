package fifteen.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadTeacher {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        try{
            ois = new ObjectInputStream(
                    new FileInputStream( "Teacher.txt" )
            );
            Person per = (Person) ois.readObject();
            Teacher t1 = (Teacher) ois.readObject();
            Teacher t2 = (Teacher) ois.readObject();
            Teacher t3 = (Teacher) ois.readObject();
            System.out.println("t1的per引用和t2是否相同" + (t1.getStudent() == per));
            System.out.println("t2 和 t3 是不是同一个对象" + (t2 == t3));
            System.out.println("t1 和 t3 是不是同一个对象" + (t1 == t3));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
