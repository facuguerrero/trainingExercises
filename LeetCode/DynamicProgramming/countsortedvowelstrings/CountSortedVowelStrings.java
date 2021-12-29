import java.util.*;

class Solution {
    public static void main(String []args) {
        CountVowelStr sol = new CountVowelStr();
        System.out.println(sol.countVowelStringsOptimized(3));
    }
}


class CountVowelStr {
    // v = # vowels
    private Character[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public int countVowelStringsDP(int n) {
        // Initialization
        Map<Character, Map<Integer, Integer>> vowelsCount = new HashMap<>();
        // O(v), assuming hashmap operations O(1)
        for (int i=0; i < vowels.length; i++) {
            Map<Integer, Integer> baseCase = new HashMap<>();
            baseCase.put(1,1);
            vowelsCount.put(vowels[i], baseCase);
        }

        // Solving the problem
        Integer count = 0;
        for (int i=0; i < vowels.length; i++) {
            // So, each recursive operation takes O(v)
            // There are
            count += countVowelStringsRec(n, vowels[i], vowelsCount);
        }
        return count;
    }

    public int countVowelStringsRec(int n, Character vowel, Map<Character, Map<Integer, Integer>> vowelsCount) {
        if (vowelsCount.get(vowel).containsKey(n)) {
            return vowelsCount.get(vowel).get(n);
        }
        // If we do not take into account the recursion, almost all the operations are O(1)
        // Except for the loop. The loop takes O(v)
        Integer count = 0;
        for ( Character currentVowel : vowelsCount.keySet() ) {
            if (currentVowel.compareTo(vowel) >= 0) {
                Integer currentCount = countVowelStringsRec(n-1, currentVowel, vowelsCount);
                count += currentCount;
            }
        }
        vowelsCount.get(vowel).put(n, count);
        return count;
    }

    public int countVowelStringsOptimized(int n) {
        int[][] dp = new int[n+1][6];
        for (int i = 1; i <= 5; i++) {
            dp[0][i] = 1;
        }
        // O(VN) = O(5N) = O(N)
        for (int i = 1; i <= n; i++)
            for (int k = 1; k <= 5; k++)
                dp[i][k] = dp[i][k - 1] + dp[i - 1][k];
        return dp[n][5];
    }

    public int countVowelStringsLinearSolution(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;

        while (--n > 0) {
            a += e + i + o + u;
            e += i + o + u;
            i += o + u;
            o += u;
        }

        return a + e + i + o + u;
    }
}
