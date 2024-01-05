package com.cccccmake.leetcode.leetcode.editor.cn;

//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 983 👎 0

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 *
 * @author cccccmake
 */
public class P354_RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class SolutionN2 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        int res = 1;
        int[] dpArray = new int[n];
        Arrays.fill(dpArray, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if (height[j] < height[i]) {
                    dpArray[i] = Math.max(dpArray[i], dpArray[j] + 1);
                }
            }
            res = Math.max(dpArray[i], res);
        }
        return res;
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return pokerSimulator(height);
    }

    public int pokerSimulator(int[] pokers){
        // how many piles we have
        int piles = 0;
        // top[i] indicates the poker at the top of the ith pile
        int[] top = new int[pokers.length];
        for(int i = 0; i < pokers.length; i++){
            int poker = pokers[i];
            int left = 0;
            int right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] < poker) {
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
            // new a pile
            if (left == piles) {
                piles++;
            }
            // update the poker on the top of the pile
            top[left] = poker;
        }
        // the LIS is the number of the piles on table
        return piles;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}