package nine;

import java.math.BigDecimal;

public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal f1 = new BigDecimal( "0.05" );
        BigDecimal f2 = BigDecimal.valueOf( 0.01 );

        //因为使用 double 作为构造参数时，实际值不一定为 0.1
        BigDecimal f3 = new BigDecimal( 0.05 );

        //String 对象作为构造器参数，而不是 double 数字

        System.out.println("下面使用 String 作为 BigDecimal 构造参数的计算结果：");
        System.out.println("0.05 + 0.01 = " + f1.add( f2 ));
        System.out.println("0.05 - 0.01 = " + f1.subtract( f2 ));
        System.out.println("0.05 * 0.01 = " + f1.multiply( f2 ));
        System.out.println("0.05 / 0.01 = " + f1.divide( f2 ));

        System.out.println("下面使用 double 作为 BigDecimal 构造器参数的计算结果：");
        System.out.println("0.05 + 0.01 = " + f3.add( f2 ));
        System.out.println("0.05 - 0.01 = " + f3.subtract( f2 ) );
        System.out.println("0.05 * 0.01 = " + f3.multiply( f2 ));
        System.out.println("0.05 / 0.01 = " + f3.divide( f2 ));
    }
}
