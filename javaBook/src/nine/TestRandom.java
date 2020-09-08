package nine;

import java.util.Random;

public class TestRandom {
    public static void main(String[] args) {
        Random random = new Random(  );

        //nextXXX,---> XXX指代着不同的数据类型，会随机生成指定类型的数据
        System.out.println("rand.nextBoolean():" + random.nextBoolean());

        byte[] buufer = new byte[16];

        //从源码中可以看到，nextBytes 的修饰符是 void 说明没有返回任何参数
        //其中的功能就是填充数据到 buffer 中
        random.nextBytes( buufer );
        System.out.println( buufer.toString() );

        //
        System.out.println(random.nextInt(26));
    }
}
