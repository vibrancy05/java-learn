package day15.TCPDemo1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
    public static void main(String[] args) throws IOException, IOException {
        ServerSocket ss = new ServerSocket(8000);
        System.out.println("启动服务器");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String msg=dis.readUTF();
        int id=dis.readInt();
        System.out.println( "id=:"+id+",收到的message是："+msg);
        System.out.println("客户端的ip是："+s.getInetAddress().getHostAddress());
        System.out.println("客户端的端口是："+s.getPort());

    }
}
