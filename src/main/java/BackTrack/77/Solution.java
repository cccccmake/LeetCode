class Solution {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> nums = new ArrayDeque<>();

    public List<List<Integer>> combine(int n, int k) {
        if(k > n || n <= 0 || k <= 0) return res;
        generateCombinations(n, k, 1, nums);
        return res;
    }

    public void generateCombinations(int n, int k, int start, Deque<Integer> nums){
        if(nums.size() == k) res.add(new ArrayList<>(nums));
        for(int i = start; i <= n; i++){
            nums.addLast(i);
            generateCombinations(n, k, i + 1, nums);
            nums.removeLast();
        }
    }

    public void genBinaryString(int n, List<Integer> nums){
        if(nums.size() == n) res.add(new ArrayList<>(nums));
        for(int i = 0; i <= 1; i++){
            nums.addLast(i);
            genBinaryString(n, nums);
            nums.removeLast();
        }
    }

    // ===================== A wrong Solution ===============================
    public void backtrack(int n, int k, int start, List<Integer> rec){
        if(rec.size() == k){
            res.add(rec);
            return;
        }
        for(int i = start; i <= n; i++){
            rec.add(i);
            backtrack(n, k, i+1, rec);
            rec.remove(rec.size() - 1);
        }
        return;
    }
}