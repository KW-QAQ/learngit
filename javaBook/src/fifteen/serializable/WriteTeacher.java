package fifteen.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteTeacher {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = null;
        try{
            oos = new ObjectOutputStream(
                    new FileOutputStream( "Teacher.txt" )
            );
            Person per = new Person( "孙悟空" , 500 );
            Teacher t1 = new Teacher( "唐僧" , per);
            Teacher t2 = new Teacher( "菩提祖师" , per );
            oos.writeObject( per );
            oos.writeObject( t1 );
            oos.writeObject( t2 );
            oos.writeObject( t2 );

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(oos != null){
                oos.close();
            }
        }
    }
}
