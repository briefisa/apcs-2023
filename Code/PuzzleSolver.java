import java.util.ArrayList;

public class PuzzleSolver {

    public static void main(String[] args) {
        int[] puzzle = {};
        System.out.println(solve(puzzle, 18));
    }
    
    public static String solve(int[] p, int goal) {
        String output = "";
        ArrayList<Integer> puzzle = toList(p);
        goal -= puzzle.remove(0);
        System.out.println(listToString(puzzle));
        ArrayList<Integer> b = recurse(puzzle, goal);

        for (int num : puzzle) {
            if (b.indexOf(num) != -1) {
                output += " - " + num;
            } else {
                output += " + " + num;
            }
        }
        return "" + p[0] + output;
    }

    public static ArrayList<Integer> recurse(ArrayList<Integer> p, int goal) {

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
        a = shuffle(a);
        b = shuffle(b);
        int remainder = sum(a) - sum(b);

        if (remainder == goal) {
            return b;
        } else if (remainder > goal) {
            ArrayList<Integer> a2 = new ArrayList<Integer>();
            for (int num : a) {
                a2.add(num);
            }
            hold = recurse(a2, sum(a2) - remainder + goal);
            for (int num : hold) {
                b.add(num);
                a.remove(a.indexOf(num));
            }
            return b;
        } else {
            hold = recurse(b, sum(b) - remainder + goal);
            for (int num : hold) {
                a.add(num);
                b.remove(b.indexOf(num));
            }
            return b;
        }
    
    }   


    public static int sum(ArrayList<Integer> a) {
        int count = 0;
        for (int num : a) {
            count += num;
        }
        return count;
    }
    
    public static ArrayList<Integer> shuffle(ArrayList<Integer> a) {
        for (int i = a.size() - 1; i > 0; i--) {
            int random = (int)(Math.random()*i);
            int hold = a.get(random);
            a.set(random, a.get(i));
            a.set(i, hold);
        }
        return a;
    }
    
    public static ArrayList<Integer> toList(int[] a) {
        ArrayList<Integer> output = new ArrayList<Integer>();
    
        for (int num : a) {
            output.add(num);
        }
        return output;
    }

    public static String listToString(ArrayList<Integer> a) {
        String output = " {";
        for (int num : a) {
            output += num + ", ";
        }
        output += "}\n";
        return output;
    }
}