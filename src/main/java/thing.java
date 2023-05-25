
import java.util.regex.*;

public class thing {
    public static void main(String[] args) {
        String input1 = "abc";
        String input2 = "a1b";
        String input3 = "abb";
        String input4 = "ab";

        String regex = "a..b";
        Pattern pattern = Pattern.compile(regex);

        System.out.println(pattern.matcher(input1).matches());  // true
        System.out.println(pattern.matcher(input2).matches());  // true
        System.out.println(pattern.matcher(input3).matches());  // false
        System.out.println(pattern.matcher(input4).matches());  // false
    }
}