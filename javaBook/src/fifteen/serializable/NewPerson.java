package fifteen.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NewPerson implements Externalizable {

    private static final long serialVersionUID = -1L;

    private String name;
    private transient int age;

    public NewPerson(){

    }
    public NewPerson(String name , int age){
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
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

    //保存对象的状态
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject( new StringBuilder( name ).reverse() );
        out.writeInt( age );
    }

    //实现反序列化
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = ((StringBuilder)in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
