package day10;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        System.out.println("StreamDemo2");
        Collection<String> names = new ArrayList<>();
        names.add("张三");
        names.add("张三");
        names.add("张三丰");
        names.add("李四");
        names.add("王五");
        names.add("赵六");
        names.stream().filter(name -> name.startsWith("张")).forEach(System.out::println);
        System.out.println("====================================================");
        List<Double> Scores = new ArrayList<>();
        Scores.add(90.5);
        Scores.add(90.5);
        Scores.add(80.5);
        Scores.add(70.5);
        Scores.add(60.5);
        Scores.add(50.5);
        //Scores.stream().filter(score -> score > 60).forEach(System.out::println);
        Scores.stream().sorted().forEach(System.out::println);
        System.out.println("====================================================");
        Scores.stream().sorted((s1,s2)->s2.compareTo(s1)).forEach(System.out::println);
        System.out.println("====================================================");
        Scores.stream().sorted((s1,s2)->Double.compare(s2, s1)).limit(4).distinct().forEach(System.out::println);
        System.out.println("====================================================");
        Scores.stream().map(score -> "+10分后："+(score + 10)).forEach(System.out::println);
        System.out.println("====================================================");
        //合并流
        Stream<String> stream1 = names.stream();
        Stream<Double> stream2 = Scores.stream();
        Stream<Object> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);
        System.out.println("====================================================");
        //收集到list集合中
        //流只能收集一次，故不能用stream1
        Stream<String> stream4 = names.stream();
        List<String> list1=stream4.collect(Collectors.toList());
        System.out.println(list1);
        System.out.println("====================================================");
        //收集到set集合中
        Stream<String> stream5 = names.stream();
        Set<String> set1=stream5.collect(Collectors.toSet());
        System.out.println(set1);
        System.out.println("====================================================");
        //收集到数组中
        Stream<String> stream6 = names.stream();
        String[] array1=stream6.toArray(String[]::new);
        System.out.println(array1);


    }
}
