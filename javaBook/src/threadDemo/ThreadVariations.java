package threadDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class InnerThread1{
    private int countDown = 5;
    private Inner inner;
    public class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }

        public void run(){
            try{
                while (true){
                    System.out.println(this);
                    if(--countDown == 0){
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep( 10 );
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        public String toString(){
            return getName() + ":" + countDown;
        }
    }

    public InnerThread1(String name){
        inner = new Inner( name );
    }
}

class InnerThread2{
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name){
        t = new Thread( name ){
            public void run(){
                try{
                    while (true){
                        System.out.println(this);
                        if(--countDown == 0){
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep( 10 );
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            public String toString(){
                return getName() + ": " + countDown;
            }
        };
        t.start();

    }
}

class InnerRunnable1{
    private int countDown = 5;
    private Inner inner;
    class Inner implements Runnable{
        Thread t;
        Inner(String name){
            t = new Thread( this , name );
            t.start();
        }

        @Override
        public void run() {
            try{
                while (true){
                    System.out.println(this);
                    if(--countDown == 0){
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep( 10 );
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public String toString(){
            return t.getName() + ": " + countDown;
        }
    }

    public InnerRunnable1(String name){
        inner = new Inner( name );
    }
}

class InnerRunnable2{
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name){
        t = new Thread( new Runnable() {
            @Override
            public void run() {
                try{
                    while (true){
                        System.out.println(this);
                        if(--countDown == 0){
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep( 10 );
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            public String toString(){
                return t.getName() + ": " + countDown;
            }
        } );
        t.start();
    }
}
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1( "InnerTHread1" );
        new InnerThread2( "InnerTHread2" );
        new InnerRunnable1( "InnerRunnable1" );
        new InnerRunnable2( "InnerRunnable2" );

    }
}
