package day15.TCPDemo3;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo3 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8000);
        System.out.println("启动服务器");
        while (true) {
            Socket socket = ss.accept();
            new ServerReader(socket).start();
        }

    }
}
