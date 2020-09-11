package packageClass;

public class Primitive2String {
    public static void main(String[] args) {
        String intStr = "123";

        //把一个特定字符串转换成 int 变量
        int it = Integer.parseInt( intStr );

        String floatStr = "4.56";
        float ft = Float.parseFloat( floatStr );
        System.out.println(ft);

        //把一个 float 变量转换为 String 变量
        String ftStr = String.valueOf( 2.3455f );
        System.out.println(ftStr);
    }
}
