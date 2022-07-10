class Solution {
    public int maxSubArray(int[] nums) {
		int sum = 0;
		int maxValue = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			maxValue = Math.max(sum, maxValue);
			if(sum < 0)
				sum = 0;
		}
		return maxValue;
    }
}

/* Consider the following situation: */

/* 1. nums[i] > 0: */
/*     Just sum them all. */
/* 2. nums[i] < 0: */
/* for(int n : nums){ */
/*     sum += n; */
/*     res = max(sum, res); */
/*     sum = 0; */
/* } */
/* We have to reset sum to 0 at the last step cause we need to update the res. */
/* 3. The combination of the above mentioned situation, that's what we are asked. */
