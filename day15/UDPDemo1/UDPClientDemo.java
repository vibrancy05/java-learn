package day15.UDPDemo1;

import java.net.*;

public class UDPClientDemo {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        System.out.println("启动客户端");
        byte[] buf = "hello,UDP,这是一段信息".getBytes();
        DatagramPacket packet = new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),8080);
        socket.send(packet);
        socket.close();
    }
}
