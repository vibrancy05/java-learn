package day9;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //用LinkedList做一个队列对象
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("张三");
        queue.addLast("李四");
        queue.addLast("王五");
        queue.addLast("赵六");
        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue);
        System.out.println("=========================");
        //用LinkedList做一个栈对象
        LinkedList<String> stack = new LinkedList<>();
        stack.addLast("张三");
        stack.addLast("李四");
        stack.addLast("王五");
        stack.addLast("赵六");
        System.out.println(stack);
        System.out.println(stack.removeLast());
        System.out.println(stack);
    }
}
