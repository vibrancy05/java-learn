package day4;

public class SalaryDemo {
    public static void main(String[] args) {
        GetSet employee=new GetSet(5000,500);
        employee.setBaseSalary(5000);
        //employee.baseSalary=-2000;
        employee.setBaseSalary(6000);
        employee.setBonus(500);
        System.out.println("Base Salary of employee is "+employee.getBaseSalary());
        System.out.println("Salary of employee is "+employee.getSalary());
    }
}
