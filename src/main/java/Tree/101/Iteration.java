class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root);
    }

    public boolean compare(TreeNode root) {
        Queue<TreeNode> layerRec = new LinkedList<>();
        layerRec.offer(root.left);
        layerRec.offer(root.right);
        while (!layerRec.isEmpty()) {
            TreeNode left = layerRec.remove();
            TreeNode right = layerRec.remove();
            if(left == null && right == null) continue;
            else if(left != null && right == null) return false;
            else if(left == null && right != null) return false;
            else if(left.val != right.val) return false;
            // dealing with the value pairs.
            layerRec.offer(left.left);
            layerRec.offer(right.right);
            layerRec.offer(left.right);
            layerRec.offer(right.left);
        }
        return true;
    }
}