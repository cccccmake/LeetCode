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
    TreeNode parent;
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            else if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else{
                TreeNode tmp = root.right;
                while(tmp.left != null) tmp = tmp.left;
                tmp.left = root.left;
                root = root.right;
                return root;
            }
        }
        if(root.val < key) root.right = deleteNode(root.right, key);
        if(root.val > key) root.left = deleteNode(root.left, key);
        return root;
    }
}