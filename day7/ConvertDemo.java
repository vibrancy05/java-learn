package day7;

public class ConvertDemo {
    public static void main(String[] args) {
        String sentence = "   i am a good boy and i love sports";
        System.out.println(convert(sentence));
    }

    public static String convert(String sentence) {
        String result = sentence;
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }
        result = sentence.trim();
        String firstletter=result.substring(0,1).toUpperCase();
        result = firstletter+result.substring(1);
        return result;
    }
}

