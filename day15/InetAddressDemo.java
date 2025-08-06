package day15;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) {
        try {
            // 获取本机的InetAddress对象
            InetAddress local = java.net.InetAddress.getLocalHost();
            System.out.println(local.getHostName());
            System.out.println(local.getHostAddress());
            InetAddress inet = InetAddress.getByName("www.baidu.com");
            System.out.println(inet.getHostName());
            System.out.println(inet.getHostAddress());
            System.out.println(inet.isReachable(5000));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
