package threadDemo.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class RthThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int i = 0;
        for(; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName()
            + " 的循环变量 i 的值：" + i);
        }
        return i;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //创建 Callable 对象
        RthThread rt = new RthThread();
        //使用 FutureTask 来包装 Callable 对象
        FutureTask<Integer> task = new FutureTask<Integer>( rt );

        for(int i = 0 ; i < 100 ; i++){
            System.out.println(Thread.currentThread().getName()
            + " 的循环变量 i 的值：" + i);
            if(i == 20){
                //实质还是以 Callable 对象来创建，并启动线程
                new Thread( task , "有返回值的线程" ).start();
            }
        }

        try{
            //获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
