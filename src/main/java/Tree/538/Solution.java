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
    public TreeNode convertBST(TreeNode root) {
        getVal(root);
        return root;
    }

    public void getVal(TreeNode root){
        if(root == null) return;
        int right = getVal(root.right);
        root.val += right;
        int left = getVal(root.left);
        if(root.left != null)
            root.left.val += root.val;
        return;
    }
}