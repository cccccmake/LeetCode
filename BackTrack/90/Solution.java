import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int startIdx){
        res.add(new ArrayList<>(path));
        if(startIdx >= nums.length){
            return;
        }

        for(int i = startIdx; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i - 1] == false)
                continue;
            else{
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, i+1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
            // fuck it!!!
            // return;
        }
        return;
    }
}