package day5;

public class CodeBlock {
        //类创建的流程和顺序
        //静态成员变量初始化->静态代码块->静态成员变量赋值->静态方法
        public static int num = 100;
    public CodeBlock() {
            System.out.println("无参构造方法");
        }
        //对象创建的流程和顺序
        //成员变量初始化->构造代码块->构造方法->普通方法
        public void func () {
            System.out.println("普通方法");
        }
        //构造代码块在每一次创建对象之前执行
        {
            System.out.println("构造代码块");
        }
        //静态代码块只在类加载和初始化之前执行一次
        static {
            System.out.println("num的初始值是" + num);
            System.out.println("静态代码块");
        }
}
