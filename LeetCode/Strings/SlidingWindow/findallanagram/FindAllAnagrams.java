import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
  public static void main(String []args) {
      FindAllAnagrams sol = new FindAllAnagrams();
      System.out.println(sol.findAllAnagrams("cbaebabacd", "abc"));
  }
}

class FindAllAnagrams {
    public List<Integer> findAllAnagrams(String s, String p) {
        Map<Character, Integer> table = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            Integer currentCount = table.getOrDefault(p.charAt(i), 0) + 1;
            table.put(p.charAt(i), currentCount);
        }

        if(s.length() < p.length() || s.length() == 0) return ans;

        int begin = 0, end = 0, word_size = p.length();
        int counter = table.size();

        while(end  < s.length()){
            Character endchar = s.charAt(end);

            if(table.containsKey(endchar)) {
                table.put(endchar, table.get(endchar) - 1);
                if(table.get(endchar) == 0) counter--;
            }

            end += 1;

            while(counter == 0){
                if(end - begin == word_size) {
                    ans.add(begin);
                }

                char beginchar = s.charAt(begin);

                if(table.containsKey(beginchar)){
                    table.put(beginchar, table.get(beginchar) + 1);
                    if(table.get(beginchar) > 0) counter++;
                }

                begin++;
            }
        }

        return ans;
    }
}
