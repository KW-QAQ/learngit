package nine;

import java.util.Scanner;

public class TestScannerLong {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );

        //判断是否还有下一个 long 整数
        while (sc.hasNextLong()){
            //输出输入项
            System.out.println("键盘输入的内容是：" + sc.nextLong());
        }
    }
}
