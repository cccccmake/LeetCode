import java.util.ArrayList;
import java.util.List;

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null)
            return res;
        traverse(root, path, res);
        return res;
    }

    public void traverse(TreeNode root, List<Integer> path, List<String> res){
        path.add(root.val);

        if(root.left == null && root.right == null){
            StringBuilder pathElem = new StringBuilder();
            int i = 0;
            for(; i < path.size() - 1; i++){
                pathElem.append(path.get(i).toString());
                pathElem.append("->");
            }
            pathElem.append(path.get(i).toString());
            res.add(pathElem.toString());
            return;
        }

        if(root.left != null){
            traverse(root.left, path, res);
            path.remove(path.size() - 1);
        }
        if(root.right != null){
            traverse(root.right, path, res);
            path.remove(path.size() - 1);
        }
    }
}