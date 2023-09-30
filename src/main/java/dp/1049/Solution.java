package Dyncmic;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int item : stones)
            sum += item;
        int target = sum / 2;
        int[] dpArray = new int[15001];
        for(int i = 0; i < stones.length; i++){
            for(int j = target; j >= stones[i]; j--){
                dpArray[j] = Math.max(dpArray[j], dpArray[j - stones[i]] + stones[i]);
            }
        }
        return sum - dpArray[target] - dpArray[target];
    }
}