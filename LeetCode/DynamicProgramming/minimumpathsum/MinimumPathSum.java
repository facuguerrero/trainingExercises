import java.util.*;

class Solution {
    public static void main(String []args) {
        MinPathSum sol = new MinPathSum();
        System.out.println(sol.minPathSum(new int[][]{ {1,3,1}, {1,5,1}, {4,2,1}}));
    }
}

class MinPathSum {
  public int minPathSum(int[][] grid) {
      int M = grid.length;
      int N = grid[0].length;

      // Algorithm takes O(MN)
      for(int i=0; i<M; i++) {
          for(int j=0; j<N; j++) {
              if(i==0 && j==0) {
                  continue;
              }
              if(i==0) {
                  grid[i][j] = grid[i][j] + grid[i][j-1];
              }
              if(j==0) {
                  grid[i][j] = grid[i][j] + grid[i-1][j];
              }
              if(i!=0 && j!=0){
                  grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
              }
          }
      }
      return grid[M-1][N-1];
  }
}
