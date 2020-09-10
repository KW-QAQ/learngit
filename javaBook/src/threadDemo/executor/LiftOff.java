package threadDemo.executor;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}
    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + "),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
//            Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(10);
                TimeUnit.SECONDS.sleep(10);
                TimeUnit.MINUTES.sleep(10);
                Thread.sleep(10);
                Thread.sleep(10*1000);
                Thread.sleep(10*60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
