package day8;

public class CustomExceptionDemo {
    public static void main(String[] args) {
        // 测试检查型异常
        try {
            UserAccount youngUser = new UserAccount("小明", 16, 1000);
        } catch (InvalidAgeException e) {
            System.out.println("捕获到InvalidAgeException: " + e.getMessage());
        }

        // 测试非检查型异常
        UserAccount account = null;
        try {
            account = new UserAccount("张三", 25, 500);

            // 测试正常操作
            account.deposit(200);
            System.out.println("当前余额: " + account.getBalance());

            // 测试取款金额为负数
            account.withdraw(-100);
        } catch (InvalidAgeException e) {
            System.out.println("捕获到InvalidAgeException: " + e.getMessage());
        } catch (NegativeAmountException e) {
            System.out.println("捕获到NegativeAmountException: " + e.getMessage());
        }

        // 测试余额不足
        try {
            if (account != null) {
                account.withdraw(1000);
            }
        } catch (NegativeAmountException e) {
            System.out.println("捕获到NegativeAmountException: " + e.getMessage());
        }
    }
}
