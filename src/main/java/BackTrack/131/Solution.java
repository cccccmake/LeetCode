class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<List<String>> partition(String s) {
        if(s.length() == 1 || s.length() == 0){
            path.add(s);
            res.add(path);
            return res;
        }
        backtrack(s, 0);
        return res;
    }

    public boolean isString(String s){
        if(s.length() == 0 || s.length() == 1) return true;
        char start = s.charAt(0);
        char end = s.charAt(s.length() - 1);
        if(start != end) return false;
        return isString(s.substring(1, s.length() - 1));
    }

    public void backtrack(String s, int startIdx){
        // if(sb.length() == length){
        //     if(isString(sb.toString()))
        //         path.add(sb.toString());
        //     if(startIdx + length == s.length() + 1)
        //         res.add(new ArrayList<>(path));
        //     return;
        // }
        if(startIdx >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i < s.length(); i++){
            String tmp = s.substring(startIdx, i + 1);
            if(isString(tmp)){
                path.add(tmp);
            }else
                continue;
            backtrack(s, i+1);
            path.remove(path.size() - 1);
        }
        return;
    }
}
