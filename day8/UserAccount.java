package day8;

class UserAccount {
    private String name;
    private int age;
    private double balance;

    public UserAccount(String name, int age, double balance) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("用户年龄必须大于18岁");
        }
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("取款金额不能为负数");
        }
        if (amount > balance) {
            throw new NegativeAmountException("余额不足");
        }
        balance -= amount;
        System.out.println("成功取款: " + amount + "元");
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("存款金额不能为负数");
        }
        balance += amount;
        System.out.println("成功存款: " + amount + "元");
    }

    public double getBalance() {
        return balance;
    }
}
