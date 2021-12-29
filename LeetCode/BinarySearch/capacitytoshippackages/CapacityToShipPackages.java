import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
  public static void main(String []args) {
      CapacityToShipPackages sol = new CapacityToShipPackages();
      System.out.println(sol.shipWithinDays(new int[][]{ {1,2,3,4,5,6,7,8,9,10} }, 5));
  }
}

class CapacityToShipPackages {
  public int shipWithinDays(int[] weights, int days) {
      // We are going to perform a binary search between the capacity boundaries.
      // Min bound is max(weights) because we have to ship all the elements in the list.
      // Max bound is the sum of all of them, which would be the same as shipping them all together.
      Integer left = 0;
      Integer right = 0;
      for (int w: weights) {
          left = Math.max(left, w);
          right += w;
      }
      while (left < right) {
          Integer mid = left + ((right - left) / 2);
          if (this.feasible(mid, weights, days)) {
              right = mid;
          }
          else {
              left = mid + 1;
          }
      }
      return left;
  }

  public Boolean feasible(int capacity, int[] weights, int D) {
      Integer days = 1;
      Integer total = 0;
      for (int weight: weights) {
          total += weight;
          // too heavy, wait for the next day
          if (total > capacity) {
              total = weight;
              days += 1;
              // cannot ship within D days
              if (days > D) {
                  return false;
              }
          }
      };
      return true;
  }
}
