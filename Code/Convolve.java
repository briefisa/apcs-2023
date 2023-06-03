import java.util.ArrayList;
import java.awt.Graphics;

public class Convolve {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2};
        int[] c = dumbConvolve(a, b);
        String str = "";
        for (int num : c) {
            str = str + num + ", ";
        }
        System.out.print("[" + str.substring(0, str.length() - 2) + "]");
    }

    public static int[] dumbConvolve(int[] a, int[] b) {
        int[] output = new int[a.length + b.length - 1];
        for(int i = 0; i < a.length + b.length - 1; i++) {
            int num = 0;
            for(int j = i; j >= 0 && i - j < b.length; j--) {
                if (j < a.length) {
                    num += a[j]*b[i - j];
                }
            }
            output[i] = num;
        }
        return output;
    }
}
