package com.training.slidingwindow.longestsubstring;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }
    String[] chars = s.split("");
    Map<String, Integer> includedChars = new HashMap<>();
    includedChars.put(chars[0], 0);

    int longestSubstring = 1;
    int init = 0;
    for (int x = 1; x < chars.length; x++) {
      if (includedChars.containsKey(chars[x]) && includedChars.get(chars[x]) >= init) {
        init = includedChars.get(chars[x]) + 1;
      } else {
        longestSubstring = Math.max(longestSubstring, x - init + 1);
      }
      includedChars.put(chars[x], x);
    }

    return longestSubstring;
  }
}
