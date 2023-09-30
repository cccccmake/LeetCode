class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null && root2 != null) return root2;
        if(root1 != null && root2 == null) return root1;
        root1.val += root2.val;
        TreeNode newLeft = mergeTrees(root1.left, root2.left);
        TreeNode newRight = mergeTrees(root1.right, root2.right);
        root1.left = newLeft;
        root1.right = newRight;
        return root1;
    }
}