package threadDemo;

class Account{
    /*
        定义一个 ThreadLocal 类型的变量，该变量将是一个线程局部变量
        每个线程都会保留该变量的一个副本
     */
    private ThreadLocal<String> name = new ThreadLocal<String>();

    //定义一个初始化 name 属性的构造器
    public Account(String str){

        //ThreadLocal 的 set（）方法
        //设置此线程局部变量中，当前线程副本中的值
        this.name.set( str );

        //下面代码，可以看到输出"初始名"
        System.out.println("------" + this.name.get());
    }

    //定义了 name 属性的 setter 和 getter 方法
    public String getName(){
        return name.get();
    }
    public void setName(String name){
        this.name.set( name );
    }
}

class MyTest extends Thread{
    //定义一个 Account 属性
    private Account account;
    public MyTest(Account account , String name){
        super(name);
        this.account = account;
    }
    public void run(){
        //循环 10 次
        for(int i = 0 ; i < 10 ; i++){
            //当 i == 6 时，输出将账户名替换成当前线程名
            if(i == 6){
                account.setName( this.getName() );
            }

            //输出同一个账户的账户名和循环变量
            System.out.println(account.getName()
            + " 账户的 i 值：" + i);
        }
    }
}
public class ThreadLocalTest {
    public static void main(String[] args) {
        //启动两条线程，两条线程共享同一个 Account
        Account at = new Account( "初始名" );

        /*
        虽然两条线程共享同一个账户，即只有一个账户名
        但由于账户名时 ThreadLocal 类型的，所以两条线程将
        导致有同一个 Account，但有两个账户名的副本，每条线程
        都完全拥有各自的账户名副本，所以当 i == 6 时，将会看到
        两条线程访问同一个账户时，看到不同的账户名
         */
        new MyTest( at , "线程家" ).start();
        new MyTest( at , "线程已" ).start();
    }
}
