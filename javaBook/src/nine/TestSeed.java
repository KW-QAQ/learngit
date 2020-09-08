package nine;

import java.util.Random;

public class TestSeed {
    public static void main(String[] args) {
        Random r1 = new Random( 50 );
        System.out.println("第一个种子为 50 的对象");
        System.out.println("r1.nextBoolean():"+r1.nextBoolean());
        System.out.println("r1.nextInt():"+r1.nextInt(  ));
        System.out.println("r1.nextDouble():"+r1.nextDouble());
        System.out.println("r1.nextGaussian():"+r1.nextGaussian());

        Random r2 = new Random( 50 );
        System.out.println("第二个种子为 50 的对象");

        System.out.println("r2.nextBoolean():"+r2.nextBoolean());
        System.out.println("r2.nextInt():"+r2.nextInt(  ));
        System.out.println("r2.nextDouble():"+r2.nextDouble());
        System.out.println("r2.nextGaussian():"+r2.nextGaussian());
    }
}
