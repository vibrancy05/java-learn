package day15.TCPDemo3;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ServerReader extends  Thread{
    private Socket socket;
    public ServerReader(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            //1.获取输入流
            java.io.InputStream is = socket.getInputStream();
            //2.把输入流转换成字符输入流
            java.io.DataInputStream dis = new java.io.DataInputStream(is);
            //4.读取数据
            while(true){
                String data = dis.readUTF();
                System.out.println("服务端收到数据："+data);
                System.out.println("服务端收到数据来自IP地址："+socket.getInetAddress().getHostAddress());
                System.out.println("服务端收到数据来自："+socket.getPort()+"端口");
                System.out.println("--------------------------------------------");
            }
        } catch (IOException e) {
            System.out.println("客户端异常断开或读取错误: " + socket.getInetAddress().getHostAddress());
        }
    }
}

