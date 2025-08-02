package day11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) {
        copyFile("src\\day11\\1.txt", "src\\day11\\2.txt");
    }

    public static void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 创建输入流，读取源文件
            fis = new FileInputStream(srcPath);
            // 创建输出流，写入目标文件
            fos = new FileOutputStream(destPath);

            // 定义缓冲区，提高复制效率
            byte[] buffer = new byte[1024];
            int len;

            // 循环读取并写入数据
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("文件复制成功！");

        } catch (IOException e) {
            System.out.println("文件复制失败：" + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭流资源
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

