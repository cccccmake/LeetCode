import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int startIdx){
        res.add(new ArrayList<>(path));
        if(startIdx >= nums.length)
            return;

        for(int i = startIdx; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size() - 1);
        }
        return;
    }
}