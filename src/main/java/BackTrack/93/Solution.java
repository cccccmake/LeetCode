import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(0, 0, s);
        return res;
    }

    public void backtracking(int startIdx, int pointNum, String s){
        if(pointNum == 3){
            if(isValidIP(s, startIdx, s.length() - 1))
                res.add(s);
            return;
        }
        for(int i = startIdx; i < s.length(); i++) {
            if(isValidIP(s, startIdx, i)){
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                backtracking(i + 2, pointNum + 1, s);
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
            else
                break;
        }
    }

    public boolean isValidIP(String s, int startIdx, int endIdx){
        if(startIdx > endIdx) return false;
        if(s.charAt(startIdx) == '0' && startIdx != endIdx) return false;
        int num = 0;
        for(int i = startIdx; i <= endIdx; i++){
            num = num * 10 + (s.charAt(i) - '0');
            if(num > 255)
                return false;
        }
        return true;
    }
}