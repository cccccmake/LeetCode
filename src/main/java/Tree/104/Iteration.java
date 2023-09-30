import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return getDepth(root);
    }

    public int getDepth(TreeNode root){
        int res = 0;
        Queue<TreeNode> layerRec = new LinkedList<>();
        layerRec.offer(root);
        while(layerRec.isEmpty() != true){
            res += 1;
            int size = layerRec.size();
            while(size-- > 0){
                TreeNode tmpNode = layerRec.remove();
                if(tmpNode.left != null) layerRec.offer(tmpNode.left);
                if(tmpNode.right != null) layerRec.offer(tmpNode.right);
            }
        }
        return res;
    }
}