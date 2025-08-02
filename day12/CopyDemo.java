package day12;

import java.io.*;

public class CopyDemo {

    /**
     * 使用缓冲字节流按字节数组形式复制文件
     * @param srcPath 源文件路径
     * @param destPath 目标文件路径
     * @throws IOException IO异常
     */
    public static void copyFileByBufferedStream(String srcPath, String destPath) throws IOException {
        // 创建缓冲输入流和缓冲输出流
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

            // 定义字节数组作为缓冲区
            byte[] buffer = new byte[1024];
            int len; // 记录实际读取到的字节数

            // 循环读取并写入
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }

            // 刷新缓冲区
            bos.flush();
        }
    }

    public static void main(String[] args) {
        try {
            // 示例：复制文件
            copyFileByBufferedStream("D:\\Java-code\\day12\\src\\day12\\1.txt", "D:\\Java-code\\day12\\src\\day12\\2.txt");
            System.out.println("文件复制成功！");
        } catch (IOException e) {
            System.err.println("文件复制失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
