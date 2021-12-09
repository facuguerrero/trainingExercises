import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private final static int INITIAL = 1;

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int movesUp = n - r_q;
        int movesDown = r_q - INITIAL;
        int movesRight = n - c_q;
        int movesLeft = c_q - INITIAL;

        int movesDownRight = Math.min(movesRight, movesDown);
        int movesUpRight = Math.min(movesRight, movesUp);
        int movesDownLeft = Math.min(movesLeft, movesDown);
        int movesUpLeft = Math.min(movesLeft, movesUp);
        int allAttackPossibilities = 0;

        // First, calculate right & left posibilities
        allAttackPossibilities += movesRight;
        allAttackPossibilities += movesLeft;

        // Second, calculate up & down posibilities
        allAttackPossibilities += movesUp;
        allAttackPossibilities += movesDown;

        // Sum all the diagonal posibilities
        allAttackPossibilities += movesUpLeft;
        allAttackPossibilities += movesDownLeft;
        allAttackPossibilities += movesUpRight;
        allAttackPossibilities += movesDownRight;
        System.out.println(allAttackPossibilities);

        for (int i=0; i<k; i++) {
            int r_o = obstacles[i][0];
            int c_o = obstacles[i][1];

            // there are in the same row
            if (r_q == r_o) {
                allAttackPossibilities -= ( c_o < c_q ) ? c_o : n - c_o;
            }
            // there are in the same col
            else if (c_q == c_o) {
                allAttackPossibilities -= ( r_o < r_q ) ? r_o : n - r_o;
            }
            else {
                // It could be in a diag or not sturb
                if (Math.abs(r_q - r_o) == Math.abs(c_q - c_o)) {
                    System.out.println("ahora");
                    //It's in one diagonal
                    // Down right
                    if (c_q < c_o && r_o < r_q ) {
                        allAttackPossibilities -= (movesDownRight - Math.abs(r_q - r_o)- 1);
                    }
                    // Down left
                    else if (c_o < c_q && r_o < r_q ) {
                        allAttackPossibilities -= (movesDownLeft - Math.abs(r_q - r_o) -1);
                    }
                    // Up Right
                    else if (c_q < c_o && r_q < r_o ) {
                        allAttackPossibilities -= (movesUpRight - Math.abs(r_q - r_o) -1);
                    }
                    // Up Left
                    else if (c_o < c_q && r_o < r_q ) {
                        allAttackPossibilities -= (movesUpLeft - Math.abs(r_q - r_o)-1);
                    }
                }
            }
        }

        return allAttackPossibilities;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
