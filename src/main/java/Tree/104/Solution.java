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
    public int maxDepth(TreeNode root) {
        int count = 0;
        if(root == null) return count;
        count++;
        int res = getDepth(root, count);
        return res;
    }

    public int getDepth(TreeNode root, int count){
        if(root == null) return count;
        count ++;
        int left = getDepth(root.left, count);
        int right = getDepth(root.right, count);
        return left > right ? left : right;
    }
}