/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start

import java.util.LinkedList;
import java.util.Queue;

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
    // private Integer maxDepth = 0;
    public int maxDepthDFS(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }

    /**
     * The BFS Version of the solution
     * 
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if (root != null)
            levelQueue.add(root);
        int res = 0;
        while (!levelQueue.isEmpty()) {
            int levelQueueSize = levelQueue.size();
            for (int i = 0; i < levelQueueSize; i++) {
                TreeNode queueElem = levelQueue.poll();
                if (queueElem.left != null)
                    levelQueue.offer(queueElem.left);
                if (queueElem.right != null)
                    levelQueue.offer(queueElem.right);
            }
            res++;
        }
        return res;
    }
}
// @lc code=end
