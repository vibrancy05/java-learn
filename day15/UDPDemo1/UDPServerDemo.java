package day15.UDPDemo1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8080);
        System.out.println("启动服务器");
        byte[] buf = new byte[1024*64];
        DatagramPacket packet = new DatagramPacket(buf,1024);
        socket.receive(packet);
        int length = packet.getLength();
        String data =new String(buf,0,length);
        System.out.println("服务端收到以下信息："+data);
        String ip = packet.getAddress().getHostAddress();
        int port = packet.getPort();
        System.out.println("服务端收到来自"+ip+":"+port+"的数据");

    }
}
