/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int[] preorder;
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        // update the key-value pair, where key is the value of the treenode
        for (int i = 0; i < inorder.length; i++)
            inorderMap.put(inorder[i], i);
        return dfs(0, preorder.length - 1, 0);
    }

    // public void dfs(TreeNode root, Map<Integer, Integer> preMap, Map<Integer, Integer> inMap, int[] preorder,
    //         int[] inorder) {
    //     int leftIndex = preMap.get(root.val) + 1;
    //     int rightIndex = inMap.get(root.val) + 1;
    //     if (leftIndex >= preorder.length) {
    //         root.left = null;
    //         return;
    //     } else {
    //         root.left = new TreeNode(preorder[leftIndex]);
    //     }
    //     if (rightIndex >= preorder.length) {
    //         root.right = null;
    //         return;
    //     } else {
    //         root.right = new TreeNode(preorder[rightIndex]);
    //     }
    //     dfs(root.left, preMap, inMap, preorder, inorder);
    //     dfs(root.right, preMap, inMap, preorder, inorder);
    //     return;
    // }

    public TreeNode dfs(int preStart, int preEnd, int inStart){
        if(preStart > preEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = inorderMap.get(root.val);
        int leftCount = rootIndex - inStart;
        root.left = dfs(preStart + 1, preStart + leftCount, inStart);
        root.right = dfs(preStart + leftCount + 1, preEnd, rootIndex + 1);
        return root;
    }
}
// @lc code=end
