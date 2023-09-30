//class Solution {
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> rec = new ArrayList<>();
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        backtrack(k, n, 0);
//        return res;
//    }
//
//    public void backtrack(int k, int n, int sum){
//        if(rec.size() == k){
//            if(sum == n) res.add(new ArrayList<>(rec));
//            return;
//        }
//        for(int i = 1; i <= 9; i++){
//            rec.add(i);
//            sum += i;
//            backtrack(k, n, sum);
//            rec.remove(rec.size() - 1);
//        }
//        return;
//    }
//}

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> rec = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 0, 1);
        return res;
    }

    public void backtrack(int k, int n, int sum, int startIdx){
        if(rec.size() == k){
            if(sum == n) res.add(new ArrayList<>(rec));
            return;
        }
        for(int i = startIdx; i <= 9; i++){
            rec.add(i);
            sum += i;
            backtrack(k, n, sum, i+1);
            // don't forget to reset the sum
            sum -= i;
            rec.remove(rec.size() - 1);
        }
        return;
    }
}