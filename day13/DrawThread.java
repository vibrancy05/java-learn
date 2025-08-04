package day13;

public class DrawThread extends Thread {
    private BankAccount ba;
    private double drawAmount;

    public DrawThread(String name,BankAccount ba) {
        super(name);
        this.ba=ba;
    }
    public void run(){
        ba.draw(1000);
    }
    
}
