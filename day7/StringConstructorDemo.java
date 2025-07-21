package day7;

public class StringConstructorDemo {
    public static void main(String[] args) {
        String s1 = "abc";
        System.out.println(s1);
        System.out.println(s1.hashCode());
        String s2 = new String("abc");
        System.out.println(s2);
        System.out.println(s2.hashCode());
        String s3 = new String(new byte[]{97,98,99});
        System.out.println(s3);
        System.out.println(s3.hashCode());
        //新建了一个char数组，并把数组中的内容转换成字符串
        String s4 = new String(new char[]{'a','b','c'});
        System.out.println(s4);
        System.out.println(s4.hashCode());
    }
}
