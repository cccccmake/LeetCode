/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    private int[] nums;
    private int[] tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int lowbit(int x){
        return x & (-x);
    }

    private void add(int index, int val){
        while(index < tree.length){
            tree[index] += val;
            index += lowbit(index);
        }
    }

    private int prefixSum(int index){
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= lowbit(index);
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

