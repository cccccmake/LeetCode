import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s.length() == 0)
            return res;
        Set<Character> rec = new HashSet<>();
        for(int startIdx = 0; startIdx < s.length(); startIdx++){
            char baseChar = s.charAt(startIdx);
            rec.clear();
            rec.add(baseChar);
            for(int endIdx = startIdx + 1; endIdx < s.length(); endIdx++){
                char curChar = s.charAt(endIdx);
                if(!rec.contains(curChar)){
                    rec.add(curChar);
                    // endIdx++;
                    res = Math.max(endIdx - startIdx + 1, res);
                } 
                else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solu = new Solution();
        System.out.println(solu.lengthOfLongestSubstring("pwwkew"));
    }
}