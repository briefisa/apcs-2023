package unit11;
import java.util.ArrayList;

// 2019 FRQ #2
// https://apcentral.collegeboard.org/media/pdf/ap19-frq-computer-science-a.pdf#page=7
public class StepTracker {

    private double minSteps;
    private ArrayList<Double> days;

    public StepTracker (double minSteps) {
        this.minSteps = minSteps;
        days = new ArrayList<Double>();
    }

    public void addDailySteps(double steps) {
        days.add(steps);
    }

    public int activeDays() {
        int output = 0;
        for (double a : days) {
            if (a >= minSteps) {
                output++;
            }
        }
        return output;
    }

    public double averageSteps() {
        double totalSteps = 0.0;
        for (double a : days) {
            totalSteps += a;
        }
        if (days.size() == 0) {
            return 0.0;
        } else {
            return totalSteps / days.size();
        }
    }

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("bad panda");
    }

    public static void main(String[] args) {
        // uncomment the following lines to test your code
         StepTracker tr = new StepTracker(10000);
         check(tr.activeDays() == 0);
         check(tr.averageSteps() == 0.0);
         tr.addDailySteps(9000);
         tr.addDailySteps(5000);
         check(tr.activeDays() == 0);
         check(tr.averageSteps() == 7000.0);
         tr.addDailySteps(13000);
         check(tr.activeDays() == 1);
         check(tr.averageSteps() == 9000.0);
         tr.addDailySteps(23000);
         tr.addDailySteps(1111);
         check(tr.activeDays() == 2);
         check(tr.averageSteps() == 10222.2);
         System.out.println("Happy Panda! \uD83D\uDC3C");
    }
}
