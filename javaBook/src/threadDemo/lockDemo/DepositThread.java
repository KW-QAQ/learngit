package threadDemo.lockDemo;

public class DepositThread extends Thread {
    //模拟用户账号
    private Account account;

    //当前取钱线程所希望存款的钱数
    private double depositAmount;

    public DepositThread(String name , Account account , double depositAmount){
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    //重复 100 次执行存款操作
    public void run(){
        for(int i = 0 ; i < 100 ; i++){
            account.deposit( depositAmount );
        }
    }
}
