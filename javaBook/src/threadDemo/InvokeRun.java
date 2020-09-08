package threadDemo;

public class InvokeRun extends Thread {
    private int i;
    //重写run 方法，run 方法的方法体，就是线程执行体
    public void run(){
        for( ; i < 100 ; i++ ){
            //直接调用 run 方法时，Thread 的 this.getName 返回的是该对象的名字
            //而不是当前线程的名字
            //使用 Thread.currentThread().getName() 总是获取当前线程名字
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0 ; i < 100 ; i++){
            //调用 Thread 的 currentThread 方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if(i == 20){
                new InvokeRun().run();
                new InvokeRun().start();
            }
        }
    }
}
