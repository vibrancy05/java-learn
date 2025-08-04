package day13;

public class ThreadAPIDemo {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.setName("线程1");
        t1.start();
        System.out.println("t1的线程名：" + t1.getName());
        Thread t2 = new MyThread();
        t2.setName("线程2");
        t2.start();
        System.out.println("t2的线程名：" + t2.getName());
        Thread t3=new MyThreadWithName("线程3");
        t3.start();
        System.out.println("t3的线程名：" + t3.getName());
        Thread m = Thread.currentThread();
        m.setName("主线程");
        System.out.println("主线程名：" + m.getName());

    }
}
class MyThreadWithName extends Thread{
    public MyThreadWithName(String name)
    {
        super("自定义子线程");
    }

    public void run()
    {
        for(int i=0;i<100;i++)
        {
            System.out.println(getName() + "正在运行，i=" + i);
        }
    }
}