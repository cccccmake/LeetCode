class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, int newTarget, int startIdx){
        // if there is no this statement, will cause overflow
        if(newTarget < 0) return;
        if(newTarget == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIdx; i < candidates.length; i++){
            path.add(candidates[i]);
            newTarget -= candidates[i];
            backtrack(candidates, newTarget, i);
            path.remove(path.size() - 1);
            newTarget += candidates[i];
        }
        return;
    }
}