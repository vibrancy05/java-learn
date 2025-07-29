package MovieManageModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Movie {
    private String movieName;
    private double Score;
    private String director;
    private double price;
}
