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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root, targetSum);
    }

    public boolean traverse(TreeNode root, int targetSum){
        // reaches the null node
        if(root == null) return false;
        // reaches the leaf
        else if(root.left == null && root.right == null) return targetSum == root.val;
        // update the targetSum safely: Cause the root is not null now
        targetSum -= root.val;
        // using the updated targetSum to perform the traverse on the left subtree and right subtree
        if(traverse(root.left, targetSum) || traverse(root.right, targetSum))
            return true;
        return false; 
    }
}