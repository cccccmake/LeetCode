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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> nodeKeeper = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        nodeKeeper.push(root);
        while(!nodeKeeper.isEmpty()){
            TreeNode tmpNode = nodeKeeper.pop();
            res.add(tmpNode.val);
            if(tmpNode.right != null) nodeKeeper.add(tmpNode.right);
            if(tmpNode.left != null) nodeKeeper.add(tmpNode.left);
        }
        return res;
    }
}