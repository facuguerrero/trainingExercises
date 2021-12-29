import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
  public static void main(String []args) {
      FirstBadVersion sol = new FirstBadVersion();
      System.out.println(sol.firstBadVersion(5));
  }
}

class FirstBadVersion {
  public int firstBadVersion(int n) {
      Integer begin = 1;
      Integer end = n;
      while (begin < end) {
          Integer mid = begin + ((end - begin) / 2);
          if (this.isBadVersion(mid)) {
              end = mid;
          }
          else {
              begin = mid + 1;
          }
      }
      return begin;
  }

  public Boolean isBadVersion(Integer n) {
      return n == 4; // is just an example
  }
}
