package threadDemo.demo;

public class TestDraw {
    public static void main(String[] args) {
        //创建一个账户
        Account account = new Account( "1234567" , 0 );

        new DrawThread( "取钱者" , account , 800 ).start();
        new DepositThread( "存款者1" , account , 800 ).start();
        new DepositThread( "存款者2" , account , 800 ).start();
        new DepositThread( "存款者3" , account , 800 ).start();
    }
}
