package fifteen.serializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
    public static void main(String[] args) {
        //对象流
        ObjectOutputStream oos = null;

        try{
            //创建一个 ObjectOutputStream 输出流
            oos = new ObjectOutputStream(
                    new FileOutputStream( "object.txt" ) );
            Person per = new Person( "孙悟空" , 500 );
            //将 per 对象写入输出流
            oos.writeObject( per );
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
