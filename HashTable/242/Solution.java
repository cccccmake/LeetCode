import java.util.*;
import java.io.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] charRec = new int[26];
        for(int i = 0; i < s.length(); i++){
            charRec[s.charAt(i) - 'a']++;
            charRec[t.charAt(i) - 'a']--;
        }
        for(int i = 0; i < charRec.length; i++)
            if(charRec[i] != 0)
                return false;
        return true;
    }
}