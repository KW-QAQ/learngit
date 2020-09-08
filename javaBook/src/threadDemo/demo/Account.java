package threadDemo.demo;

public class Account {
    private String accountNo;
    private double balance;

    //表示账户中是否已有存款的旗标
    private boolean flag = false;

    public Account(){

    }
    public Account(String accountNo , double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    //取钱
    public synchronized void draw(double drawAmount){

        try {
            //如果 flag 为假，表名账户中还没有人存钱进去，取钱方法阻塞
            if(!flag){
                wait();
            }
            else
            {
                //执行取钱
                System.out.println(Thread.currentThread().getName() +
                        "取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("余额为：" + balance);
                //讲标识账户是否已有存款的旗标设为 false
                flag = false;
                //唤醒其他线程
                notifyAll();

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //存钱
    public synchronized void deposit(double depositAmount){
        try {

            //如果 flag 为真，表明账户中已有人存钱进去，则存钱方法阻塞
            if(flag){
                wait();
            }else{
                //执行存款
                System.out.println(Thread.currentThread().getName() +
                        "存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为；" + balance);
                //将表示账户是否已有存款的旗标设为 true
                flag = true;
                notifyAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
