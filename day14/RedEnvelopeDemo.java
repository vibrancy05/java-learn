package day14;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedEnvelopeDemo {
    public static void main(String[] args) {
        List<Integer> redEnvelope = getRedEnvelope();
        for(int i=1;i<=100;i++){
            new PeopleGetRedEnvelope(redEnvelope,i+"号").start();
        }
    }
    public static List<Integer> getRedEnvelope(){
        Random r=new Random();
        List<Integer> redEnvelope = new ArrayList<>();
        for(int i=1;i<=160;i++){
            redEnvelope.add(r.nextInt(30)+1);
        }
        for(int i=1;i<=40;i++){
            redEnvelope.add(r.nextInt(70)+1);
        }
        return redEnvelope;
    }
}
