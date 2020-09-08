package nine;

public class TestIdentityHashCode {
    public static void main(String[] args) {
        //下面程序，s1 和 s2 是两个不同对象
        String s1 = new String("Hello");
        String s2 = new String( "Hello" );

        //String 重写了 hashCode 方法 ———— 改为根据字符序列计算 hashCode 值,
        //因为 s1 和 s2 的字符序列相同，所以它们的 hashCode 方法返回值相同
        System.out.println(s1.hashCode() + "----" + s2.hashCode());
        //s1 和 s2 是不同的字符串对象，所以它们的 identityHashCode 值不同
        System.out.println(System.identityHashCode( s1 ) + "----" +
                System.identityHashCode( s2 ));
        String s3 = "Java";
        String s4 = "Java";

        //s3 和 s4 是相同的字符串对象，所以它们的 identityHashCode 值相同
        System.out.println(System.identityHashCode( s3 ) + "----" +
                System.identityHashCode( s4 ));
    }
}
