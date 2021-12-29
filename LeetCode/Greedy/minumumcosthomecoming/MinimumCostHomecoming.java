import java.util.*;

class Solution {
    public static void main(String []args) {
        MinimumCostHomecoming sol = new MinimumCostHomecoming();
        System.out.println(sol.minimumCostHomecoming(
                new int[]{1,0},
                new int[]{2,3},
                new int[]{5,4,3},
                new int[]{8,2,6,7}
        ));
    }
}

class MinimumCostHomecoming {
  public int minimumCostHomecoming(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
      Integer totalCost = 0;
      Integer i = startPos[0];
      while (i != homePos[0]) {
          i += (startPos[0] < homePos[0]) ? 1 : -1;
          totalCost += rowCosts[i];
      }
      Integer j = startPos[1];
      while (j != homePos[1]) {
          j += (startPos[1] < homePos[1]) ? 1 : -1;
          totalCost += colCosts[j];
      }
      return totalCost;
  }
}
