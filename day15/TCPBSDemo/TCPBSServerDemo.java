package day15.TCPBSDemo;
import day15.TCPDemo3.ServerReader;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TCPBSServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8080);
        System.out.println("启动服务器");
        System.out.println("等待客户端连接");
        ExecutorService pool =new ThreadPoolExecutor(5,10,1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket socket = ss.accept();
            System.out.println("一个客户端上线了："+socket.getInetAddress().getHostAddress());
            pool.execute(new BSServerReader(socket));
        }

    }
}
