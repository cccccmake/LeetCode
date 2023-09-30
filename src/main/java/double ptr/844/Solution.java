class Solution {
    public boolean backspaceCompare(String s, String t) {
        String resS = cal(s);
        String resT = cal(t);
        return resT.equals(resS);
    }
    public static String cal(String s){
        StringBuilder res = new StringBuilder();
        int slow = 0;
        int fast = 0;
        for(; fast < s.length(); fast++){
            if(s.charAt(fast) != '#'){
                slow++;
                res.append(s.charAt(fast));
            }
            else if(slow == 0)
                continue;
            else{
                slow--;
                res.deleteCharAt(slow);
            }
        }
        return res.toString();
    }
}