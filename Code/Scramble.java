public class Scramble {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        scramble(a);
        for (int b : a) {
            System.out.print(b + " ");
        }
    }
    
    static int[] scramble(int[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            int random = (int)(Math.random()*i);
            int hold = a[random];
            a[random] = a[i];
            a[i] = hold;
        }
        return a;
    }
}
