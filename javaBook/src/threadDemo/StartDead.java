package threadDemo;

public class StartDead extends Thread {
    private int i;
    //重写 run 方法，run 方法的方法体就是线程执行体
    public void run(){
        for( ; i < 100 ; i++){
            //当线程类继承 Thread 类时，可以直接调用 getName() 方法来返回当前线程名
            //如果想获取当前线程，直接使用 this 即可
            //Thread 对象的 getName() 返回当前线程的名字
            System.out.println(getName() + " " + i);

        }
    }

    public static void main(String[] args) {
        //创建线程对象
        StartDead sd = new StartDead();
        for(int i = 0 ; i < 1000 ; i++){
            //调用 Thread 的 currentThread 方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20){
                //启动线程
                sd.start();
                //判断启动后的 isAlive()
                System.out.println(sd.isAlive());

            }
            //只有当线程处于新建，死亡两种状态是，isAlive 返回 false
            //因为 i > 20，则该线程肯定已经启动了，所以当 sd.isAlive() 为假时
            //只可能是死亡状态
            if(i > 20 && !sd.isAlive()){
                System.out.println("aaa");
                sd.start();
            }
        }
    }
}
