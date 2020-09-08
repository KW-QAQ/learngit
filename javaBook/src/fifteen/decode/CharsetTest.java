package fifteen.decode;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetTest {
    public static void main(String[] args) {
        //获取全部字符集
        SortedMap<String , Charset> map = Charset.availableCharsets();
        for(String alias : map.keySet()){
            System.out.println(map.get( alias ));
        }
    }
}
