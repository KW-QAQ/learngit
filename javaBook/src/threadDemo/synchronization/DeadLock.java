package threadDemo.synchronization;

class A{
    public synchronized void foo(B b){
        System.out.println("当前线程名：" +
                Thread.currentThread().getName() + " 进入了A实例的foo方法");
        try{
            Thread.sleep( 200 );
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("当前线程名：" +
                Thread.currentThread().getName() + "企图调用 B 实例的 last 方法");
        b.last();
    }
    public synchronized void last(){
        System.out.println("进入了 A 类的 last 方法内部");
    }
}
class B{
    public synchronized void bar(A a){
        System.out.println("当前线程名：" +
                Thread.currentThread().getName() + "进入了 B 实例的 bar 方法");
        try {
            Thread.sleep( 200 );
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("当前线程名："+
                Thread.currentThread().getName() + "企图调用 A 实例的 last 方法");
        a.last();
    }
    public synchronized void last(){
        System.out.println("进入了 B 类的 last 方法内部");
    }

}
public class DeadLock implements Runnable{
    A a = new A();
    B b = new B();
    @Override
    public void run() {
        Thread.currentThread().setName( "福线程" );
        //调用 b 对象的bar方法
        b.bar(a);
        System.out.println("进入了福线程之后");
    }
    public void init(){
        Thread.currentThread().setName( "主线程" );
        a.foo( b );
        System.out.println("进入了主线程之后");
    }

    public static void main(String[] args) {
        DeadLock dl = new DeadLock();

        new Thread( dl ).start();

        dl.init();
    }
}
