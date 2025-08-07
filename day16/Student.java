package day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private double score;
    public Student(String name){
        this.name = name;
    }
    public void show(){
        System.out.println("show()");
    }

}

