import java.util.LinkedList;
import java.util.Queue;

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
    public int findBottomLeftValue(TreeNode root) {
        return traverse(root);
    }

    public int traverse(TreeNode root){
        if(root == null) return 0;
        int res = 0;
        Queue<TreeNode> layerRec = new LinkedList<>();
        layerRec.offer(root);
        while(!layerRec.isEmpty()){
            int size = layerRec.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = layerRec.peek();
                if(i == 0) res = tmp.val;
                layerRec.poll();
                if(tmp.left != null) layerRec.offer(tmp.left);
                if(tmp.right != null) layerRec.offer(tmp.right);
            }
        }
        return res;
    }
}