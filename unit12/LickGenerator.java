package unit12;
import java.util.ArrayList;
import java.util.HashMap;

public class LickGenerator {

    private HashMap<String, int[]> scales;
    private int[][] intervals;

    public LickGenerator() {
        scales = new HashMap<String, int[]>();
        scales.put("major", new int[] {1, 3, 5, 6, 8, 10, 12});
        scales.put("dorian", new int[] {1, 3, 4, 6, 8, 10, 11});
        scales.put("lydian", new int[] {1, 3, 5, 7, 8, 10, 12});
        scales.put("mixolydian", new int[] {1, 3, 5, 6, 8, 10, 11, 12});
        scales.put("natural minor", new int[] {1, 3, 4, 6, 8, 9, 11});

    }

    public ArrayList<Integer> makeLick(String scale) {
        
    }
    
    public static void main(String[] args) {

    }
}
