package day15.TCPDemo1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8000);
        System.out.println("启动客户端");
        OutputStream out = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(out);
        dout.writeUTF("hello world");
    }
}
