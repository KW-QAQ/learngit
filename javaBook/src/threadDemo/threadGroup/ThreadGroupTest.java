package threadDemo.threadGroup;

class TestThread extends Thread {
    //提供指定线程名的构造器
    public TestThread(String name){
        super(name);
    }

    //提供指定线程名，线程组的构造器
    public TestThread(ThreadGroup group , String name){
        super(group , name);
    }

    public void run(){
        for(int i = 0 ; i < 20 ; i++){
            System.out.println(getName() + " 线程的 i 变量"+i);
        }
    }
}
public class ThreadGroupTest{
    public static void main(String[] args) {
        //获取主线程所在的线程组
        //所有线程的默认线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字：" + mainGroup.getName());
        System.out.println("主线程组是否是后台线程组："+mainGroup.isDaemon());
        new TestThread( "主线程祖的线程" ).start();
        ThreadGroup tp = new ThreadGroup( "新线程组" );
        tp.setDaemon( true );
        System.out.println("tp 线程组是否是后台线程组：" + tp.isDaemon());
        TestThread tt = new TestThread( tp , "tp的线程假" );
        tt.start();
        new TestThread( tp , "tp的线程222" ).start();
    }
}

