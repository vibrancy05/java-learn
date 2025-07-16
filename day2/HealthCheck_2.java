package main;
import java.text.DecimalFormat;
import java.util.Scanner;
public class HealthCheck_2 {
    public static void main(String[] args) {
            //1.输入个人信息
            double height=readValue("height", 0, 300);

            double weight=readValue("weight", 0, 200);

            int age=(int)readValue("age", 0, 120);

            byte gender=(byte)readValue("gender", 0, 1);

            byte activityLevel=(byte)readValue("activity level", 1, 5);

            //2.输出个人信息总结
            System.out.println("=================================================");
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
            DecimalFormat df = new DecimalFormat("#.00");
            double bmi = getBmi(weight, height);
            double bmr = getBmr(gender, weight, height, age);
            double tdee = getTdee(activityLevel, bmr);
            double dailyCalories = getDailyCalories(tdee, bmi);

            //5.计算每日摄入的营养素的质量
            double protein= calcProtein(dailyCalories);
            double carbohydrates=calcCarbohydrates(dailyCalories);
            double fat=calcFat(dailyCalories);

            getBodyType(df, bmi);
            printResult(dailyCalories, carbohydrates, protein, fat, bmr, tdee);
    }
    public static double readValue(String prompt,double min,double max){
        Scanner sc = new Scanner(System.in);
        double value;
        while(true) {
            System.out.println("Enter your "+prompt+":");
            value = sc.nextDouble();
            if (min <= value && value <= max) {
                break;
            }
            System.out.println("Invalid input! Please enter a number between" +min+ "and" +max);
        }
        return value;
    }

    public static double getBmi(double weight, double height) {
        double bmi = weight / (height / 100 * height / 100);
        return bmi;
    }

    public static double getBmr(byte gender, double weight, double height, int age) {
        DecimalFormat df = new DecimalFormat("#.00");
        double bmr= gender ==1?
            (13.7* weight +4.799* height -5.677* age +88.362):
            (9.247* weight +3.098* height -4.330* age +447.593);
        return bmr;
    }

    public static void getBodyType(DecimalFormat df, double bmi) {
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
    }

    public static double getTdee(byte activityLevel, double bmr) {
        double activityFactor=switch (activityLevel) {
            case 1 -> 1.2;
            case 2 -> 1.375;
            case 3 -> 1.55;
            case 4 -> 1.725;
            case 5 -> 1.9;
            default -> throw new IllegalArgumentException("Invalid activity level");
        };
        double tdee = bmr *activityFactor;
        return tdee;
    }

    public static double getDailyCalories(double tdee, double bmi) {
        double dailyCalories= tdee;
        if(bmi <18.5){
            dailyCalories= tdee +300;
        }
        else if(bmi >=18.5 && bmi <=24.9){
            dailyCalories= tdee;
        }
        else if(bmi >24.9 && bmi <=29.9){
            dailyCalories= tdee -300;
        }
        else if(bmi >29.9){
            dailyCalories= tdee -500;
        }
        return dailyCalories;
    }

    public static double calcFat(double dailyCalories) {
        final double FAT_PERCENTAGE = 0.2;
        final int FAT_CALORIES = 9;
        return dailyCalories * FAT_PERCENTAGE / FAT_CALORIES;
    }
    public static double calcCarbohydrates(double dailyCalories) {
        final double CARBOHYDRATE_PERCENTAGE = 0.5;
        final int CARBOHYDRATE_CALORIES = 4;
        return dailyCalories * CARBOHYDRATE_PERCENTAGE / CARBOHYDRATE_CALORIES;
    }
    public static double calcProtein(double dailyCalories) {
        final double PROTEIN_PERCENTAGE = 0.3;
        final int PROTEIN_CALORIES = 4;
        return dailyCalories * PROTEIN_PERCENTAGE / PROTEIN_CALORIES;
    }

    public static void printResult(
        double dailyCalories,
        double carbohydrates,
        double protein,
        double fat,
        double bmr,
        double tdee
    )
    {
        DecimalFormat df = new DecimalFormat("#.##");
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
