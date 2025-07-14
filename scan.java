package pack1;
import java.util.Scanner;
public class scan {
    public static void main(String[] args)
    {   //录入整数
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int a = sc.nextInt();
        System.out.println("你输入的整数是："+a);
        //录入小数
        System.out.print("请输入一个小数:");
        double b = sc.nextDouble();
        System.out.println("你输入的小数是："+b);
        //录入字符
        System.out.print("请输入一个字符:");
        char c = sc.next().charAt(0);
        System.out.println("你输入的字符是："+c);

    }
}
