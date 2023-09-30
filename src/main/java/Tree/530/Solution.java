class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        int minimumDiff = Integer.MAX_VALUE;
        for(int i = 0; i < res.size(); i++){
            int j = i + 1;
            // need to consider the boundary overflow
            if(j < res.size() && Math.abs(res.get(j) - res.get(i)) < minimumDiff)
                // update the minimumDiff
                minimumDiff = Math.abs(res.get(j) - res.get(i));
        }
        // if there is only 0/1 node in a tree, the res should be 0
        return minimumDiff == Integer.MAX_VALUE ? 0 : minimumDiff;
    }

    public void traverse(TreeNode root, List<Integer> res){
        // traverse the tree and save the values into an array list
        if(root == null) return;
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }
}