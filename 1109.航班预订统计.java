/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    /**
     * solution in brute force style
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookingsBruteForce(int[][] bookings, int n) {
        int length = bookings.length;
        int[] res = new int[n];
        for(int[] elem : bookings){
            for(int i = elem[0]; i <= elem[1]; i++){
                res[i - 1] += elem[2];
            }
        }
        return res;
    }
    
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        // init the diff array
        for(int[] elem : bookings){
            diff[elem[0] - 1] += elem[2];
            if(elem[1] < n)
                diff[elem[1]] -= elem[2];
        }
        for(int i = 1; i < n; i++){
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
// @lc code=end

