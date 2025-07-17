package day4;
//示例getter和setter方法
public class GetSet {
    private int baseSalary;
    private int bonus;
    public GetSet(int baseSalary, int bonus)
    {
        //构造方法,默认初始化
        setBaseSalary(baseSalary);
        setBonus(bonus);
    }
    public int getSalary()
    {

        return baseSalary+bonus;
    }
    public void setBaseSalary(int baseSalary)
    {
        if(baseSalary<0)
        {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        //this代表当前对象,访问的是当前对象的属性
        this.baseSalary = baseSalary;
    }
    public int getBaseSalary()
    {
        return baseSalary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        if(bonus<0)
        {
            throw new IllegalArgumentException("Bonus cannot be negative.");
        }
        this.bonus = bonus;
    }
}
