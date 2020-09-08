package threadDemo.synchronization;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    //封装账户编号，账户余额两个属性
    private String accountNo;
    private double balance;

    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock(  );

    public Account(){

    }
    public Account(String accountNo , double balance){
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

//    public void setBalance(double balance) {
//        this.balance = balance;
//    }

    //提供一个线程安全的 draw 同步方法来完成操作
//    public synchronized void draw(double drawAmount){
//        //账户余额 > 取钱数目
//        if(balance >= drawAmount){
//            //吐出钞票
//            System.out.println(Thread.currentThread().getName() + "取钱成功，去除钞票：" + drawAmount);
//
//
//            //修改余额
//            balance -= drawAmount;
//            System.out.println("余额：" + balance);
//        }else{
//            System.out.println(Thread.currentThread().getName() + "取钱失败");
//        }
//    }
    public void draw(double drawAmount){
        //对同步锁进行加锁
        lock.lock();
        try {
            //账户余额 > 取钱数目
            if(balance >= drawAmount){
                //吐出钞票
                System.out.println(Thread.currentThread().getName() +
                        "取钱成功，吐出钱：" + drawAmount);
                try{
                    Thread.sleep( 1 );
                }catch (Exception e){
                    e.printStackTrace();
                }

                //修改余额
                balance -= drawAmount;
                System.out.println("余额为：" + balance);
            }else{
                System.out.println(Thread.currentThread().getName() +
                        "取钱失败，余额不足");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //重写 equlas 根据 hashCode 判断相等
    public int hashCode(){
        return accountNo.hashCode();
    }

    public boolean equals(Object object){
        if(object != null && object.getClass() == Account.class){
            Account target = (Account) object;
            return target.getAccountNo().equals( accountNo );
        }
        return false;
    }
}
