package threadDemo.synchronization;

public class TestDraw {
    public static void main(String[] args) {
        //创建一个账户
        Account account = new Account( "123" , 1000 );
        //模拟两个线程对同一个账户取钱
        new DrawThread( "甲" , account , 800 ).start();
        new DrawThread( "乙" , account , 800 ).start();
    }
}
