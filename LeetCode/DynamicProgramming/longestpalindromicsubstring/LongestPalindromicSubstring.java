import java.util.*;

class Solution {
    public static void main(String []args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();
        System.out.println(sol.longestPalindrome("babad")); //bab or aba
    }
}

class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
      int n = s.length();
      String res = "";

      boolean[][] dp = new boolean[n][n];

      for (int i = n - 1; i >= 0; i--) {
          for (int e = i; e < n; e++) {
              Integer currentLen = e - i + 1;
              if (currentLen < 2) { 
                  dp[i][e] = true;
              }
              if (currentLen == 2 || currentLen == 3) {
                  dp[i][e] = s.charAt(i) == s.charAt(e);
              }
              if (currentLen > 3) {
                  dp[i][e] = (s.charAt(i) == s.charAt(e)) && dp[i+1][e-1];
              }

              if (res.length() < currentLen && dp[i][e]) {
                  res = s.substring(i, e+1);
              }
          }
      }
      return res;
  }
}
