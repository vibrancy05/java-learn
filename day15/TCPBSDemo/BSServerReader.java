package day15.TCPBSDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class BSServerReader extends  Thread{
    private Socket socket;
    public BSServerReader(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try{
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type: text/html;charset=UTF-8");
            ps.println();
            ps.println("<html>");
            ps.println("<head>");
            ps.println("<title>Hello World</title>");
            ps.println("</head>");
            ps.println("<body>");
            ps.println("<h1 style='color:red'>这是一段文字</h1>");
            ps.println("</body>");
            ps.println("</html>");
            ps.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("客户端异常断开或读取错误: " + socket.getInetAddress().getHostAddress());
        }
    }
}

