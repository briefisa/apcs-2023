import javax.swing.GroupLayout.Alignment;

public class BetterSolver {
    
    public static void main(String[] args) {
        
    }

    public static ArrayList<int> solve(ArrayList<int> puzzle, int goal) {
        int firstNum = puzzle[0];
        goal = goal - firstNum;
        puzzle.remove(0);

    }

    public static ArrayList<int> recurse(ArrayList<int> p, int goal) {
        ArrayList<Integer> puzzle = new ArrayList<Integer>();
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> hold = new ArrayList<Integer>();

        for (int num : p) {
            puzzle.add(num);
        }

        while (puzzle.size() > 0) {
            if ((sum(a) - sum(b)) > goal) {
                b.add(puzzle.remove(0));
            } else {
                a.add(puzzle.remove(0));
            }
        }

        
    }

    public static int sum(ArrayList<int> a) {
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        return sum;
    }
}
