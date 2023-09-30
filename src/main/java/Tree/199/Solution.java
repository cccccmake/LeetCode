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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        nodeQueue.offer(root);
        while(!nodeQueue.isEmpty()){
            int len = nodeQueue.size();
            for(int i = 0; i < len; i++){
                TreeNode tmpNode = nodeQueue.poll();
                if(tmpNode.left != null) nodeQueue.offer(tmpNode.left);
                if(tmpNode.right != null) nodeQueue.offer(tmpNode.right);
                if(i == len - 1) res.add(tmpNode.val);
                /*
                if(tmpNode.right != null) nodeQueue.offer(tmpNode.right);
                if(tmpNode.left != null) nodeQueue.offer(tmpNode.left);
                if(i == 0) res.add(tmpNode.val);
                */
            }
        }
        return res;
    }
}