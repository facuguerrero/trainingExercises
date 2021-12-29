import java.util.*;

class Sol {
    public static void main(String []args) {
        CountSquareSubMatrices sol = new CountSquareSubMatrices();
        sol.countSquareSubMatrices(new int[][]{ {1,0,1}, {1,1,0}, {1,1,0}}); // 7
        //sol.countSquareSubMatrices(new int[][]{ {0,1,1,1}, {1,1,1,1}, {0,1,1,1}}); //15
        //sol.countSquareSubMatrices(new int[][]{ {0,1,1}, {1,0,1}, {0,1,1}, {0,1,1}}); //9
        //sol.countSquares(new int[][]{ {1,1,1}, {1,1,1}, {1,1,1}});
    }
}


class CountSquareSubMatrices {

    public int countSquareSubMatrices(int[][] matrix) {
        Integer m = matrix.length;
        Integer n = matrix[0].length;

        int sol = 0;
        for (int k = 1; k <= Math.min(m, n); k++) {
            sol += countSquareSubMatrices(matrix, k, m, n);
        }
        return sol;
    }

    public int countSquareSubMatrices(int[][] matrix, Integer k, Integer M, Integer N) {
        int sol = 0;
        for (int aux=0; aux <= M - k; aux++) {
            for (int row = 0; row <= N - k; row++) {
                int currentRowsSum = 0;
                for (int col = aux; col < aux + k; col++) {
                    int currentElementsSum =
                            Arrays.stream(matrix[col], row, row + k)
                                    .sum();
                    if (currentElementsSum < k) {
                        break;
                    }
                    currentRowsSum += 1;
                }
                sol += currentRowsSum < k ? 0 : 1;
            }
        }

        return sol;
    }

    public int countSquares(int[][] A) {
        int res = 0;
        // Takes O(MN) time
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < A[0].length; ++j) {
                if (A[i][j] > 0 && i > 0 && j > 0) {
                    A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
                }
                System.out.println("I: "+ i + " | J: "+j+ "| VALUE: "+A[i][j]);
                res += A[i][j];
            }
        }
        System.out.println(res);
        return res;
    }
}
