package day11;

import java.io.File;
import java.io.IOException;

public class FileSearchDemo {
    public static void main(String[] args) {
        try {
            searchFile(new File("D:/"), "pycharm64.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void searchFile(File dir, String fileName) throws IOException {
        // 参数校验
        if (dir == null || fileName == null || !dir.exists()) {
            return;
        }

        // 如果是文件，直接检查文件名
        if (dir.isFile()) {
            if (dir.getName().equals(fileName)) {
                System.out.println("找到目标文件:" + dir.getAbsolutePath());
                Runtime r=Runtime.getRuntime();
                r.exec(dir.getAbsolutePath());
            }
            return;
        }

        // 如果是目录，遍历子文件
        File[] files = dir.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                try {
                    if (file.isFile()) {
                        if (file.getName().equals(fileName)) {
                            System.out.println("找到目标文件:" + file.getAbsolutePath());
                        }
                    } else {
                        searchFile(file, fileName);
                    }
                } catch (SecurityException e) {
                    // 跳过无权限访问的文件/目录
                    continue;
                }
            }
        }
    }
}
