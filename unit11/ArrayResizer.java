package unit11;

// 2021 FRQ #4
// https://apcentral.collegeboard.org/media/pdf/ap21-frq-computer-science-a.pdf#page=14
import java.util.Arrays;

public class ArrayResizer {
    public static boolean isNonZeroRow(int[][] array2D, int r) {
        for (int num : array2D[r]) {
            if (num == 0) {
                return false;
            }
        }
        return true;
    }

    public static int numNonZeroRows(int[][] array2D) {
        /* implementation not shown */
        int count = 0;
        for (int r = 0; r < array2D.length; r++) {
            if (ArrayResizer.isNonZeroRow(array2D, r))
                count++;
        }
        return count;
    }

    public static int[][] resize(int[][] array2D) {
        int[][] output = new int[numNonZeroRows(array2D)][array2D[0].length];
        int outputRow = 0;
        for (int i = 0; i < array2D.length; i++) {
            if (isNonZeroRow(array2D, i)) {
                for (int j = 0; j < array2D[0].length; j++) {
                    output[outputRow][j] = array2D[i][j];
                }
                outputRow++;
            }
        }
        return output;
    }

    //Test method (ignore)
    public static void print(int[][] a) {
        for (int[] row : a) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.print("\n");
        }
        System.out.println("rows = " + a.length);
        System.out.println("cols = " + a[0].length);
    }

    public static void check(boolean test) throws AssertionError {
        if (!test)
            throw new AssertionError("sad panda");
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 1, 0 },
                { 1, 3, 2 },
                { 0, 0, 0 },
                { 4, 5, 6 } };
        check(ArrayResizer.isNonZeroRow(arr, 0) == false);
        check(ArrayResizer.isNonZeroRow(arr, 1) == true);
        check(ArrayResizer.isNonZeroRow(arr, 2) == false);
        check(ArrayResizer.isNonZeroRow(arr, 3) == true);

        int[][] smaller = ArrayResizer.resize(arr);
        int[][] target = { { 1, 3, 2 },{ 4, 5, 6 } };
        check(smaller.length == 2);
        check(Arrays.deepEquals(smaller, target));
        System.out.println("Happy Panda! \uD83D\uDC3C");
    }
}