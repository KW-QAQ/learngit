package threadDemo.lockDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private String accountNo;
    private double balance;

    //显示定义 Lock 对象
    private final Lock lock = new ReentrantLock(  );
    //获取Lock对象对应的条件变量
    private final Condition cond = lock.newCondition();

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
    public  void draw(double drawAmount){
        lock.lock();
        try {
            //如果 flag 为假，表名账户中还没有人存钱进去，取钱方法阻塞
            if(!flag){
                cond.await();
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
                cond.signalAll();

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //存钱
    public void deposit(double depositAmount){
        lock.lock();
        try {

            //如果 flag 为真，表明账户中已有人存钱进去，则存钱方法阻塞
            if(flag){
                cond.await();
            }else{
                //执行存款
                System.out.println(Thread.currentThread().getName() +
                        "存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为；" + balance);
                //将表示账户是否已有存款的旗标设为 true
                flag = true;
                cond.signalAll();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }



}
