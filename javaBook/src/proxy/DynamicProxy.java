package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    //目标对象
    private Object targetObject;

    //绑定关系，关联到那个接口的哪些方法被调用时，执行 invoke 方法
    public Object newProxyInstance(Object targetObject){
        this.targetObject = targetObject;

        //根据传入的目标返回一个代理对象
        return Proxy.newProxyInstance( targetObject.getClass().getClassLoader() , targetObject.getClass().getInterfaces(),this );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start -- >>");

        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);
        }

        Object ret = null;
        try {
            //原对象方法调用前处理日志信息
            System.out.println("start");

            //调用目标方法
            ret = method.invoke( targetObject , args );
            //原对象方法调用后处理日志信息
            System.out.println("success");

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("error");
        }
        return ret;
    }
}
