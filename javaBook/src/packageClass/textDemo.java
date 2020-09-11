package packageClass;

public class textDemo {
    public static void main(String[] args) {
        boolean b1 = true;
        //通过构造器，把 b1 基本类型变量，包装成包装类对象
        Boolean blobj = new Boolean( b1 );

        int it = 5;
        Integer itObj = new Integer( it );

        //把一个字符串，转换为 Float 对象
        Float fl = new Float( "4.56" );

        //把一个字符串转为 Boolean 对象
        Boolean bObj = new Boolean( "false" );

        boolean bb= bObj.booleanValue();
        int i = itObj.intValue();
        float f = fl.floatValue();
        System.out.println(bb  + " " + i + " " + f);

        Character cObj = new Character( 'a' );

        //下面程序运行将出现 java.lang.NumberFormatException (数据格式异常)
        Long lObj = new Long("ddd");

    }
}
