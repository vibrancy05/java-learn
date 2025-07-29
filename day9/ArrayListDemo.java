package day9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("world");
        System.out.println(list);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("----------------");
        for(String s : list){
            System.out.println(s);
        }
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println( s);
            }
        });*/
        //并发修改删除，删除所有带java的元素并输出剩余元素
        System.out.println("================================");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String s = iterator.next();
            if(s.contains("java")){
                iterator.remove();
            }
        }
        list.forEach(s -> System.out.println(s));
    }
}
