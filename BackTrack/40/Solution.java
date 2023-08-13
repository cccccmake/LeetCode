import java.util.Arrays;
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    public void backtrack(int[] candidates, int newTarget, int startIdx){
        if(newTarget == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(newTarget < 0)
            return;
        for(int i = startIdx; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false) continue;
            path.add(candidates[i]);
            newTarget -= candidates[i];
            used[i] = true;
            backtrack(candidates, newTarget, i + 1);
            path.remove(path.size() - 1);
            newTarget += candidates[i];
            used[i] = false;
        }
        return;
    }
}