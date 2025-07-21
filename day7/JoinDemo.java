package day7;

public class JoinDemo {
    public static void main(String[] args) {
        String s1="Hello";
        String s2="World";
        String s3="HelloWorld";
        String s4="Hello"+"World";//运行期间不会创建新的对象
        String s5=s1+s2;//运行过程中拼接，创建新的对象
        String s6=s1.concat(s2);
        System.out.println(s3==s4);// true
        System.out.println(s3==s5);// false
        System.out.println(s3==s6);// false
        System.out.println(s5==s6);// false
        System.out.println(s4==s5);// false
        String[] names={"张三","李四","王五"};
        //join可以拼接字符串
        String namesStr=String.join(",",names);
        System.out.println(namesStr);
        int [] numbers={1,2,3,4,5};
        StringBuilder numbersStr=new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            numbersStr.append(numbers[i]);
            if (i != numbers.length - 1) {
                numbersStr.append(",");
            }
        }
        System.out.println(numbersStr);

    }
}
