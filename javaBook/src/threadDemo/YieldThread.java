package threadDemo;

public class YieldThread extends Thread {
    public YieldThread(){

    }
    public YieldThread(String name){
        super(name);
    }
    //定义 run 方法作为线程执行体
    public void run(){
        for(int i = 0 ; i < 500 ; i++){
            System.out.println(getName() + " " +i);
            //当 i = 20 时，使用 yield方法，让当前线程让步
            if(i == 20){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        //启动两条并发线程
        YieldThread ty1 = new YieldThread( "高级" );
        //将 ty1 线程设置为最高优先级
        ty1.setPriority( Thread.MAX_PRIORITY );
        ty1.start();

        YieldThread ty2= new YieldThread( "diji" );
        //将 ty2 线程设置为最低优先级
        ty2.setPriority( Thread.MIN_PRIORITY );

        ty2.start();

    }
}
