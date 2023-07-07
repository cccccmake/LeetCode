class Solution {
    public boolean isValid(String s) {
        char[] pairRec = new char[] {'(', ')','[', ']', '{', '}'};
        Stack<Character> rec = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int rightIdx = -1;
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                rec.push(s.charAt(i));
            }else{
                if(!res.empty()) {
                    Character popVal = res.pop();
                    char toPair = popVal.charValue();
                    for (int left = 0, int right = 1;
                    right < 6;
                    left += 2, right += 2){
                        if (pairRec[left] == toPair && pairRec[right] == s.charAt(i))
                            break;
                        else if (pairRec[left] == toPair && pairRec[right] != s.charAt(i))
                            return false;
                    }
                }else{
                    return false;
                }
            }
        }
        if(!res.empty())
            return false;
        else
            return true;
    }
}