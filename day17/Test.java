package day17;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Star star = new Star("abc");
        StarService proxy =ProxyUtil.createProxy(star);
        proxy.sing("hello world");
        System.out.println(proxy.dance());
    }
}
