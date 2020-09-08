package threadDemo.lockDemo;

public class DrawThread extends Thread {
    //模拟用户账号
    private Account account;

    //当前取钱线程所希望取的钱
    private double drawAmount;

    public DrawThread(String name , Account account , double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //重复 100 次执行取钱操作
    public void run(){
        for (int i = 0 ; i < 100 ; i++){
            account.draw( drawAmount );
        }
    }
}
