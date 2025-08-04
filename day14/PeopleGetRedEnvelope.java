package day14;

import java.util.List;

public class PeopleGetRedEnvelope extends Thread{
    private List<Integer> redEnvelope;
    public PeopleGetRedEnvelope(List<Integer> redEnvelope, String name){
        super(name);
        this.redEnvelope=redEnvelope;
    }
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        while (true) {
            synchronized (redEnvelope){
                if(redEnvelope.size()==0){
                    break;
                }
                int index=(int)(Math.random()*redEnvelope.size());
                Integer money = redEnvelope.remove(index);
                System.out.println(name+"抢到红包"+money+"元");
                if(redEnvelope.size()==0){
                    System.out.println(name+"抢完红包");
                    break;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
