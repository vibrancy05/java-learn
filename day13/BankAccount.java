package day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BankAccount {
    private int balance;
    private int id;
    private final Lock lk=new ReentrantLock();
    public void BankAccount(int balance, int id){
        this.balance=balance;
        this.id=id;
    }
    //同步方法（未采用）
    public void draw(int amount)
    {
        String name=Thread.currentThread().getName();
        System.out.println("取款开始，取款金额："+amount+"，取款人："+ name);
        //Lock锁：lk.lock();
        // finally {lk.unlock();}

        //同步代码块
        synchronized (this) {
            if (this.balance >= amount) {
                System.out.println(name + "取款成功，取款金额：" + amount);
                balance -= amount;
                System.out.println(name + "取款成功，余额为：" + balance);
            } else {
                System.out.println(name + "取款失败，余额不足");
            }
        }
    }
}
