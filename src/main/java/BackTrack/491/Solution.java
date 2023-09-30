import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> findSubsequences(int[] nums) {
        // Arrays.sort(nums);
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int startIdx){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
            // no return here, as we need to traverse all nodes on the tree
        }
        // if(startIdx >= nums.length){
        //     res.add(new ArrayList<>(path));
        //     return;
        // }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIdx; i < nums.length; i++){
            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) || hs.contains(nums[i]))
                continue;

            hs.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, i+1);
            path.remove(path.size() - 1);
            used[i] = false;
            // hs.remove(nums[i]);
        }
        return;
    }
}