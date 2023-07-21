class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left != null && root.right == null && )
        if(root.val > root.left.val && root.val < root.right.val) return recursion(root, root.val, 0) && recursion(root, root.val, 1);
    }

    public boolean recursion(TreeNode root, int reference, int direction){ // direction = 0 -> left =1 -> right
        if(root == null) return true;
        if(direction == 0){
            return root.val < reference && recursion(root.left, root.val, 0) && recursion(root.right, reference, 1);
        }
        else{
            return root.val > reference && recursion(root.left, root.val, 0) && recursion(root.right, reference, 1);
        }
    }
}