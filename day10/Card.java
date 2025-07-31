package day10;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String size;
    private String color;
    private int num;
    public String toString()
    {
        return size + color;
    }
}
