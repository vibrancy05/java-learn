package day15.TCPDemo2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientDemo2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8000);
        System.out.println("启动客户端");
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("请输入要发送的内容：");
            String line = sc.nextLine();
            if("886".equals(line)){
                System.out.println("退出成功");
                socket.close();
                break;
            }
            dout.writeUTF(line);
            System.out.println("发送成功");
            dout.flush();
        }
        dout.writeUTF("hello world");
        dout.writeInt(10086);
        socket.close();
    }
}
