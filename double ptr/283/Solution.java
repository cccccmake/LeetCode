//class Solution {
//    public void moveZeroes(int[] nums) {
//        int slow = 0;
//        int fast = 0;
//        for(; fast < nums.length; fast++){
//            while(fast < nums.length && nums[fast]!= 0)
// forgot to update fast, slow would increase forever
//                nums[slow++] = nums[fast];
//        }
//        for(; slow < nums.length; slow++)
//            nums[slow] = 0;
//        return;
//    }
//}
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        for(; fast < nums.length; fast++){
            if(nums[fast] != 0)
                nums[slow++] = nums[fast];
        }
        for(; slow < nums.length; slow++)
            nums[slow] = 0;
        return;
    }
}