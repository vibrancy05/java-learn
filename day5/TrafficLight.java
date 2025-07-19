package day5;

public class TrafficLight {
    private String color;
    private TrafficLight next;
    public TrafficLight(String color){
        this.color = color;
    }
    public static final TrafficLight RED = new TrafficLight("RED");
    public static final TrafficLight YELLOW = new TrafficLight("YELLOW");
    public static final TrafficLight GREEN = new TrafficLight("GREEN");
    static{
        RED.next = GREEN;
        YELLOW.next = RED;
        GREEN.next = YELLOW;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TrafficLight getNext() {
        return next;
    }

    public void setNext(TrafficLight next) {
        this.next = next;
    }
    public static void main(String[] args) {
        System.out.println("红灯："+TrafficLight.RED.getColor());
        System.out.println("红灯的下一个灯是："+TrafficLight.RED.getNext().getColor());
        System.out.println("红灯的下一个灯的下一个灯是："+TrafficLight.RED.getNext().getNext().getColor());
    }
}
