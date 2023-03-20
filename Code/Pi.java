public class Pi {
    
    public static void main(String[] args) {
        System.out.println("Pi = " + calculatePi(0.0));
    }

    static double calculatePi(double index) {
        
        double output = 4 / ((2*index) + 1);
        if (index % 2 == 1) {
            output *= -1;
        }

        if (index > 4999) {
            return output;
        } else {
            return output + calculatePi(index + 1);
        }
    }
}
