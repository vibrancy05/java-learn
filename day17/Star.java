package day17;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Star implements StarService {
    private String name;
    public void sing(String name)
    {
        System.out.println(this.name+"-登台唱歌-"+name);
    }
    public String dance()
    {
        System.out.println(this.name + "-登台跳舞-"+ name);
        return "谢谢";
    }
}
