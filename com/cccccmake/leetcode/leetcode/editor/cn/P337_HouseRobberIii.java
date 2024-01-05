package com.cccccmake.leetcode.leetcode.editor.cn;

//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1918 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍 III
 *
 * @author cccccmake
 */
public class P337_HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337_HouseRobberIii().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            int[] res = dfs(root);
            return Math.max(res[0], res[1]);
        }

        public int[] dfs(TreeNode root) {
            if (root == null) {
                return new int[]{0, 0};
            }
            // leftRobRes[0] -> the max value we can get not robbing left subtree
            // leftRobRes[1] -> the max value we can get robbing left subtree
            int[] leftRobRes = dfs(root.left);
            int[] rightRobRes = dfs(root.right);
            int[] res = new int[2];
            // not robbing the root node, for left- and right-subtrees, we can choose rob or not
            res[0] = Math.max(leftRobRes[0], leftRobRes[1]) + Math.max(rightRobRes[0], rightRobRes[1]);
            // robbing the root node (root.val), we can not rob left- and right-subtrees
            res[1] = leftRobRes[0] + rightRobRes[0] + root.val;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}