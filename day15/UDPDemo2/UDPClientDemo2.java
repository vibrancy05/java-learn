package day15.UDPDemo2;

import java.net.*;
import java.util.Scanner;

public class UDPClientDemo2 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        System.out.println("启动客户端");
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("请输入要发送的信息:");
            String msg = sc.nextLine();
            if("exit".equals(msg)){
                System.out.println("关闭客户端");
                break;
            }
            byte[] buf = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(), 8080);
            socket.send(packet);
            System.out.println("发送成功");
        }
        socket.close();
    }
}