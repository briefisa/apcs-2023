

public class March16 {

    public static void main(String[] args) {
        System.out.println("" + power(2, 8));
    }

    static int power(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (b%2 == 1) {
            b--;
            int half = power(a, b/2);
            return a*half*half;
        } else {
            int half = power(a, b/2);
            return half*half;
        }
        
    }
}