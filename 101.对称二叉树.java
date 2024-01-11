/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // an empty tree is already symmetric. No one knows why :)
        if(root == null)
            return true;
        return recur(root.left, root.right);
    }

    /**
     * recursion function, return whether the trees with roots L and R
     * are symmetric
     * @param L
     * @param R
     * @return true or false
     */
    public boolean recur(TreeNode L, TreeNode R) {
        // if the parent of nodes L and R is already a leaf
        if (L == null && R == null) return true;
        // otherwise, the tree contains L, R, root is not symmetric
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
// @lc code=end

