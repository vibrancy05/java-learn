package main;

import java.util.Random;

public class operator {
    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt(6);
        switch (a) {
            //666还能这么用
            case 0-> System.out.println("0");
            case 1-> System.out.println("1");
            case 2-> System.out.println("2");
            case 3-> System.out.println("3");
            case 4-> System.out.println("4");
            case 5-> System.out.println("5");
         }
    }
}
