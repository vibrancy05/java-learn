package main;

public class array {
    public static void main(String[] args) {
        //数组的多种声明方法
        int[] a = new int[10];
        int[] b = {1,2,3,4,5};
        int[] c = new int[]{1,2,3,4,5,6};
        //定义字符串数组，存储食物信息
        //String[] foods = new String[3];
        //String[] foods = new String[]{"苹果","香蕉","橘子"};
        String[] foods = {"苹果","香蕉","橘子"};
        System.out.println("foods[0]:"+foods[0]);
        System.out.println("foods[1]:"+foods[1]);
        System.out.println("foods[2]:"+foods[2]);
        foods[2]="草莓";
        System.out.println("foods[2]:"+foods[2]);
        System.out.println("foods.length:"+foods.length);
        printArray(b);
        printArr(c);

    }
    //打印数组
    public static void printArray(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    //用while遍历打印数组
    public static void printArrayByWhile(int[] a){
        int i=0;
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
    }
    //可变参数
    public static void printArr(int... a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

}
