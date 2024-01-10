/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestorNormal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        else if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return null;
    }

    // recursive version
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        // Consider the feature of binary search tree
        // Both p & q's value is SMALLER than root.val => search LEFT subtree
        // Both p & q's value is LARGER than root.val => search RIGHT subtree
        if (p.val < root.val && q.val < root.val) {
            res = lowestCommonAncestor(root.left, p, q);
        }else if (p.val > root.val && q.val > root.val){
            res = lowestCommonAncestor(root.right, p, q);
        }else{
            // p.val > root.val && q.val < root.val
            // OR p.val < root.val && q.val > root.val
            res = root;
        }
        return res;
    }

    // iteration version
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Consider the feature of binary search tree
        // Both p & q's value is SMALLER than root.val => search LEFT subtree
        // Both p & q's value is LARGER than root.val => search RIGHT subtree
        while(root != null){
            if(root.val < p.val && root.val < q.val)
                root = root.right;
            else if(root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;
        }
        return root;
    }
}
// @lc code=end
