class Solution {
    public int getMinimumDifference(TreeNode root) {
        int res = 0;
        if(root == null) return res;
        int leftRes = Math.abs(root.val - findNearest(root.left, 0));
        int rightRes = Math.abs(root.val - findNearest(root.right, 1));
        return leftRes <= rightRes ? leftRes : rightRes;
    }

    public int findNearest(TreeNode root, int direction){
        if(root == null) return Integer.MAX_VALUE;
        if(direction == 0){
            while(root != null)
                root = root.right;
        }
        else{
            while(root != null)
                root = root.left;
        }
        return root.val;
    }
}