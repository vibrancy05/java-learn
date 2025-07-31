package day10;

import java.util.*;

public class Room {
    private List<Card> cards=new ArrayList<>();
    {
        String[] nums={"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        String[] colors={"♠","♥","♣","♦"};
        int compare=0;
        for(String num:nums){
            compare++;
            for(String color:colors){
                cards.add(new Card(num,color,compare));
            }
        }
        //cards.add(new Card("","joker"));
        //cards.add(new Card("","JOKER"));
        Collections.addAll(cards, new Card("","joker",++compare),new Card("","JOKER",++compare));
        System.out.println("新牌是："+cards);
    }
    public void start(){
        Collections.shuffle(cards);
        System.out.println("洗牌后："+cards);
        Map<String,List<Card>> players=new HashMap<>();
        List<Card> player1=new ArrayList<>();
        players.put("玩家1",player1);
        List< Card> player2=new ArrayList<>();
        players.put("玩家2",player2);
        List<Card> player3=new ArrayList<>();
        players.put("玩家3",player3);
        List<Card> dipai=new ArrayList<>();
        players.put("底牌",dipai);
        for(int i=0;i<cards.size();i++){
            Card card = cards.get(i);
            if(i>=51){
                dipai.add(card);
            }
            else if(i%3==0){
                player1.add(card);
            }
            else if(i%3==1){
                player2.add(card);
            }
            else{
                player3.add(card);
            }

        }
        player1.addAll(dipai);
        sortCards(player1);
        sortCards(player2);
        sortCards(player3);

        for(Map.Entry<String,List<Card>> entry:players.entrySet()){
            String name=entry.getKey();
            List<Card> cards=entry.getValue();
            System.out.println(name+"的牌是："+cards);

    }

    }

    private void sortCards(List<Card> cards) {
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getNum()-o1.getNum();
            }
        });
    }
}
