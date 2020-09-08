package fifteen.serializable;

import java.io.*;
import java.util.ArrayList;

public class Person implements Serializable {
    private String name;

    //使 java 序列化的时候，忽略该属性
    private transient int age;

    //注意此处没有提供无参数的构造器
    public Person(){
        System.out.println("测试可否有无参构造器");
    }

    public Person(String name , int age){
        System.out.println("有参构造器");
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        //进行字符序列发转
        out.writeObject( new StringBuffer( name ).reverse() );
        out.writeInt( age );
    }
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
//    private Object writeReplace() throws ObjectStreamException {
//        ArrayList<Object> list = new ArrayList<Object>(  );
//        list.add( name );
//        list.add( age );
//        return list;
//    }
}
