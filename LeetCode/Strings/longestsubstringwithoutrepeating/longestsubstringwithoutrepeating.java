class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterIndexes = new HashMap<>();
        Integer initialIndex = 0;
        Integer longestSubstring = 0;
        for (Integer i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (characterIndexes.containsKey(currentChar) && characterIndexes.get(currentChar) >= initialIndex) {
                initialIndex = Math.max(characterIndexes.get(currentChar), initialIndex) + 1;
            }
            longestSubstring = Math.max(longestSubstring, i - initialIndex + 1);
            characterIndexes.put(currentChar, i);
        }
        return longestSubstring;
    }
}
