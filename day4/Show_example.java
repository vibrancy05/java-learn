package day4;

public class Show_example {
    public static void main(String[] args) {
        Object_Oriented obj = new Object_Oriented();
        obj.age = 20;
        obj.name = "Terry";
        obj.height =1.75;
        obj.weight = 70;
        double bmi=obj.calculateBMI();
        System.out.println("BMI of "+obj.name+" is "+bmi);
    }
}
