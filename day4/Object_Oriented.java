package day4;

public class Object_Oriented {
    String name;
    int age;
    double height;
    double weight;
    double calculateBMI(){
        double bmi = weight/(height*height);
        return bmi;
    }
}
