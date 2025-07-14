package pack1;
import java.text.DecimalFormat;
import java.util.Scanner;
public class HealthCheck {
    public static void main(String[] args) {
        //1.输入个人信息
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your height(cm):");
        double height = sc.nextDouble();
        System.out.println("Enter your weight(kg):");
        double weight = sc.nextDouble();
        System.out.println("Enter your age:");
        int age = sc.nextInt();
        System.out.println("Enter your gender(1 for male, 0 for female):");
        byte gender = sc.nextByte();
        System.out.println("Enter your activity level(0-5)");
        byte activityLevel = sc.nextByte();
        //2.输出个人信息总结
        System.out.println("Your information is as follows:");
        System.out.println("Height: " + height + " cm");
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Age: " + age);
        if(gender==1)
        System.out.println("Gender: male" );
        else if(gender==0)
        System.out.println("Gender: female");
        System.out.println("Activity Level: " + activityLevel);
        //3.计算BMI
        double bmi = weight / (height / 100 * height / 100);
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("BMI: " + df.format(bmi));
        if (bmi < 18.5) {
            System.out.println("Underweight");
            System.out.println("Recommendations: Gain weight");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("Normal Weight");
            System.out.println("Recommendations: Maintain current weight");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("Overweight");
            System.out.println("Recommendations: Lose weight through exercise and diet");
        } else {
            System.out.println("Obese");
            System.out.println("Recommendations: Lose weight through exercise and diet");
        }
        //4.计算用户每日摄入热量（BMR,TDEE）
        double bmr=0;
        if(gender==1){
            bmr=88.362+13.7*weight+4.799*height-5.677*age;
        }
        else{
            bmr=447.593+9.247*weight+3.098*height-4.330*age;
        }
        double activityFactor=0;
        switch(activityLevel){
            case 0:
                activityFactor=1.2;
                break;
            case 1:
                activityFactor=1.3;
                break;
            case 2:
                activityFactor=1.4;
                break;
            case 3:
                activityFactor=1.5;
                break;
            case 4:
                activityFactor=1.6;
                break;
            case 5:
                activityFactor=1.7;
            default:
                System.out.println("Invalid input!");
        }
        double tdee =bmr*activityFactor;
        double dailyCalories=tdee;
        if(bmi<18.5){
            dailyCalories=tdee+300;
        }
        else if(bmi>=18.5 && bmi<=24.9){
            dailyCalories=tdee;
        }
        else if(bmi>24.9 && bmi<=29.9){
            dailyCalories=tdee-300;
        }
        else if(bmi>29.9){
            dailyCalories=tdee-500;
        }
        //5.计算每日摄入的营养素的质量
        double protein=0.075*dailyCalories;
        double carbohydrates=dailyCalories*0.125;
        double fat=0.2*dailyCalories/9;
        System.out.println("====================DIET PLAN====================");
        System.out.println("Your base daily calorie intake is:"+(int)bmr+" calories");
        System.out.println("Your actual daily calorie intake is:"+(int)tdee+" calories");
        System.out.println("Based on your exercise plan, we advise you to comsume:"+(int)dailyCalories+" calories each day, including");
        System.out.println("Protein:"+(int)protein+" grams");
        System.out.println("Carbonhydrate:"+(int)carbohydrates+" grams");
        System.out.println("Fat:"+(int)fat+" grams");
        System.out.println("That's all for your health advice, have a good day!");
        System.out.println("=================================================");
    }
}