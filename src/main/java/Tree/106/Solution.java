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
    public List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = que.size();

            while(len > 0){
                TreeNode tmpNode = que.poll();
                itemList.add(tmpNode.val);
                if(tmpNode.left != null) que.offer(tmpNode.left);
                if(tmpNode.right != null) que.offer(tmpNode.right);
                len--;
            }
            res.add(0, itemList);
        }
        return res;
    }
}