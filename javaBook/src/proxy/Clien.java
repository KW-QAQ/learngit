package proxy;

public class Clien {
    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        UserManager userManager = (UserManager) dynamicProxy.newProxyInstance( new UserManagerImpl() );
        userManager.addUser("111" , "张三");
    }
}
