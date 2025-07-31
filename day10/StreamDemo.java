package day10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("StreamDemo");
        Collection<String> names = new ArrayList<>();
        Stream<String> s1 = names.stream();
        Map<String,Integer> map = new HashMap<>();
        Stream<String> s2 =map.keySet().stream();
        Stream<Integer> s3 = map.values().stream();
        Stream<Map.Entry<String,Integer>> s4 = map.entrySet().stream();
        Stream<String> s5 = Stream.of("张三","李四","王五");
        s5.forEach(System.out::println);
    }
}
