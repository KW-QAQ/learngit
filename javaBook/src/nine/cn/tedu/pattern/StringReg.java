package nine.cn.tedu.pattern;

import java.util.Arrays;

public class StringReg {
    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions"
        };
        for(String msg : msgs){
            System.out.println(msg.replaceAll( "re\\w*" , "aa") );

            System.out.println( Arrays.toString(msg.split( " " )));

        }
    }
}
