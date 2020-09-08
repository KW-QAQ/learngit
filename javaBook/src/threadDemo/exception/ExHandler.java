package threadDemo.exception;

class MyExHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + "出现异常：" + e);
    }
}
public class ExHandler {
    public static void main(String[] args) {
        //设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(
                new MyExHandler()
        );
        int a = 5 / 0;
    }
}
