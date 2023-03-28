import java.util.Arrays;
import java.util.stream.Collectors;

public class Maze {
    private boolean solution;
    private char[][] maze;

    /**
     * Instantiates a Maze instance based on the provided arguments
     * 
     * @param rows the number of rows
     * @param cols the number of columns
     * @param line the values to be placed in the maze.
     */
    public Maze(int rows, int cols, String line) {
        maze = new char[rows][cols];
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (index < line.length()) {
                    maze[r][c] = line.charAt(index);
                } else {
                    maze[r][c] = '.';
                }
                index++;
            }
        }
        solution = this.hasSolution();
    }

    /**
     * @return the starting coordinates as "r c"
     */
    public String getStart() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('@');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * @return the ending coordinates as "r c"
     */
    public String getEnd() { /* Not shown, plz ignore implementation */
        int z = Arrays.stream(maze).map(String::new).collect(Collectors.joining("")).indexOf('$');
        return "" + z / maze[0].length + " " + z % maze[0].length;
    }

    /**
     * Uses recursion to see if the maze has a solution or not.
     * 
     * Suggested algorithm:
     * if R and C are in bounds and spot is !#
     * - if you are at $:
     * - - set has a solution
     * - else:
     * - - mark spot as checked
     * - - recur up
     * - - recur down
     * - - recur left
     * - - recur right
     * 
     * @param r current row index
     * @param c current column index
     */
    private void check(int r, int c) {
        if (maze[r][c] == '$') {
            solution = true;
        } else {
            if (valid(r - 1, c)) {
                maze[r - 1][c] = ',';
                check(r - 1, c);
            }
            if (valid(r, c + 1)) {
                maze[r][c + 1] = ',';
                check(r, c + 1);
            }
            if (valid(r + 1, c)) {
                maze[r + 1][c] = ',';
                check(r + 1, c);
            }
            if (valid(r, c - 1)) {
                maze[r][c - 1] = ',';
                check(r, c - 1);
            }
        }
    }

    /**
     * Determines if there is a solution (a path of '.') for this maze.
     * 
     * @return true if the maze has a path from Start (@) to End ($).
     */
    public boolean hasSolution() {
        solution = false;
        int row = Integer.parseInt(getEnd().substring(0, 1));
        int col = Integer.parseInt(getEnd().substring(2));
        this.check(row, col);
        for (int r = 0; r < maze.length; r++) {
            for (int c = 0; c < maze[0].length; c++) {
                if (maze[r][c] == ',')
                    maze[r][c] = '.';
            }
        }
        return solution;
    }

    public boolean isInBounds(int r, int c) {
        boolean r1 = (r >= 0 && r < maze.length);
        boolean c1 = (c >= 0 && c < maze[0].length);
        return (r1 && c1);
    }

    public boolean valid(int r, int c) {
        return (isInBounds(r, c) && maze[r][c] != '#' && maze[r][c] != ',');
    }

    // HINT overriding toString may be handy. :)

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        Maze example = new Maze(3, 3, "#.@.....$");
        check(example.hasSolution());

        Maze case1 = new Maze(5, 7, ".#.#....#.#.##@.....$#...#.##..#...");
        check(case1.hasSolution());

        Maze case2 = new Maze(4, 4, ".#.$.##..##.@..#");
        check(!case2.hasSolution());

        Maze test = new Maze(3, 3, "#.@.....$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#####$");
        check(!test.hasSolution());

        test = new Maze(3, 3, "##@#..#.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "#.@#.##.$");
        check(test.hasSolution());

        test = new Maze(3, 3, "##@#.##.$");
        check(!test.hasSolution());

        System.out.println("Happy Panda! \uD83D\uDC3C");

    }

}