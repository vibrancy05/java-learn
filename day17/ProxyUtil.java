package day17;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static StarService createProxy(StarService starService)
    {
        StarService proxy = (StarService) Proxy.newProxyInstance(starService.getClass().getClassLoader(), starService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
            {
                System.out.println("开始代理");
                String methodName = method.getName();
                if(methodName.equals("sing")){
                    System.out.println("代理发出唱歌请求");
                }
                else if(methodName.equals("dance")){
                    System.out.println("代理发出跳舞请求");
                }
                Object result = method.invoke(starService, args);
                System.out.println("结束代理");
                return result;
            }
        });
        return proxy;
    }
}
