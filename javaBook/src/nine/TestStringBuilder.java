package nine;

public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(  );

        //追加字符串
        sb.append( "java" );
        System.out.println(sb);

        //插入
        sb.insert( 0 , "hello ");
        System.out.println(sb);

        //替换
        sb.replace( 5 , 6 ,"," );
        System.out.println(sb);

        //删除
        sb.delete( 5 , 6 );
        System.out.println(sb);

        //反转
        sb.reverse();
        System.out.println(sb);

        System.out.println(sb.length());
        System.out.println(sb.capacity());

        //改变 StringBuilder 的长度，将只保留前面的部分
        sb.setLength( 5 );
        System.out.println(sb);
    }
}
