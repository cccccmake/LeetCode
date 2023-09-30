// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         if(root == null) return true;
//         if(root.val > root.left.val && root.val < root.right.val) return recursion(root.left, root.val, 0) && recursion(root.right, root.val, 1);
//         return false;
//     }

//     public boolean recursion(TreeNode root, int reference, int direction){ // direction = 0 -> left =1 -> right
//         if(root == null) return true;
//         if(direction == 0){
//             return root.val < reference && recursion(root.left, root.val, 0) && recursion(root.right, reference, 1);
//         }
//         else{
//             return root.val > reference && recursion(root.left, root.val, 0) && recursion(root.right, reference, 1);
//         }
//     }
// }

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         int maxVal = Integer.MIN_VALUE;
//         return traverse(root, maxVal);
//     }
//     public boolean traverse(TreeNode root, int maxVal){
//         if(root == null) return true;
//         boolean left = traverse(root.left, maxVal);
//         if(maxVal < root.val) maxVal = root.val;
//         else return false;
//         boolean right = traverse(root.right, maxVal);
//         return left && right;
//     }
// }

// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         int maxVal = Integer.MIN_VALUE;
//         TreeNode max = new TreeNode(Integer.MIN_VALUE);
//         return traverse(root, max);
//     }
//     public boolean traverse(TreeNode root, TreeNode max){
//         if(root == null) return true;
//         boolean left = traverse(root.left, max);
//         if(max.val < root.val) max.val = root.val;
//         else return false;
//         boolean right = traverse(root.right, max);
//         return left && right;
//     }
// }

// Using mid-order traverse to check whether the traverse is ordered
class Solution {
    TreeNode max;
    // the obj is default null
    // [1] TreeNode max = new TreeNode(Integer.MIN_VALUE);
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        // [1] the test case [Integer.MIN_VALUE] won't pass
        // if(max.val >= root.val)
        if(max != null && max.val >= root.val) return false;
        else max = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}