package com.training.dynamicprogramming.longestpalindromicsubstring;


class LongestPalindromicSubstring {

  public String longestPalindromeBottomUp(String s) {
        /* DP Bottom Up approach - Tabulation

        For a string to be palindrome needs to be equal to its reverse
        In other words, being n the size of the string:
        -- If the string length is odd, then s[0 : flor(n/2)] == reverse of s[flor(n/2) + 1 : s.length()]
        -- If the string length is even, then s[0 : (n/2)] == reverse of s[(n/2) : s.length()]

        The approach to fix this problem is starting with the small sub problems, save their solution
        and build from bottom to top.
        -- The smallest problem is when the string len == 1 in which the string is palindrome.
        -- The following step is to check if strings with len == 2 are palindrome.
        -- For strings 2 < len < string len, check if the first and last characters are the same
           and if the inner substring is a palindrome
        */
    int n = s.length();
    if (n == 0) {
      return "";
    }

    // DP Table: boolean[][] dp is used to store whether a substring s[i:j+1] is a palindrome.
    boolean[][] dp = new boolean[n][n]; // DP table
    int start = 0, maxLength = 1; // To store the start index and max length of the longest palindrome

    // Single Character Palindromes: All substrings of length 1 are palindromes.
    for (int i = 0; i < n; i++) {
      dp[i][i] = true;
    }

    // Two Character Palindromes: Check if two consecutive characters are the same.
    for (int i = 0; i < n - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        dp[i][i + 1] = true;
        start = i;
        maxLength = 2;
      }
    }

    // Longer Substrings: For substrings longer than 2 characters, check if the first and last characters are the same
    // and if the inner substring is a palindrome.
    for (int length = 3; length <= n; length++) {
      for (int init = 0; init < n - length + 1; init++) {
        int end = init + length - 1;
        if (s.charAt(init) == s.charAt(end) && dp[init + 1][end - 1]) {
          dp[init][end] = true;
          start = init;
          maxLength = length;
        }
      }
    }

    return s.substring(start, start + maxLength); // Return the longest palindromic substring
  }

}
