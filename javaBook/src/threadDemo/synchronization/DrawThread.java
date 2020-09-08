package threadDemo.synchronization;

public class DrawThread extends Thread {
    //模拟用户账户
    private Account account;
    //当前取钱线程所希望取的钱数量
    private double drawAmount;
    public DrawThread(String name , Account account , double drawAmount){
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    //当多头线程修改同一个共享数据时，将涉及到数据安全问题
//    public void run(){
//        synchronized (account){
//            //账户余额 > 取钱数目
//            if(account.getBalance() >= drawAmount){
//                //吐出钞票
//                System.out.println(getName() + "取钱成功，去除钞票：" + drawAmount);
///*
//            try{
//                Thread.sleep( 1 );
//            }catch (Exception e){
//                e.printStackTrace();
//            }*/
//
//                //修改余额
//                account.setBalance( account.getBalance() - drawAmount );
//                System.out.println("余额：" + account.getBalance());
//            }else{
//                System.out.println(getName() + "取钱失败");
//            }
//        }
//    }
    public void run(){
        account.draw( drawAmount );
    }
}
