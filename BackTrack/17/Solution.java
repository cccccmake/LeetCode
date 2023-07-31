class Solution {
    String[] pool = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder rec = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        backtrack(digits, 0);
        return res;
    }

    public void backtrack(String digits, int startIdx){
        // if(startIdx >= digits.length()) return;
        if(rec.length() == digits.length()){
            res.add(rec.toString());
            return;
        }
        // startIdx indicates the idx under the digits
        // iterate over the corresponding string, e.g., pool['2'-'0'] = 'abc'
        for(int i = startIdx; i < pool[digits.charAt(startIdx)-'0'].length(); i++){
            rec.append(pool[digits.charAt(startIdx) - '0'].charAt(i));
            // move to the next char in digits, i.e., dive.
            backtrack(digits, startIdx + 1);
            rec.deleteCharAt(rec.length() - 1);
        }
    }
}