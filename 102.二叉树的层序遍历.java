/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // there is no tree, return directly
        if (root == null)
            return res;
        // a queue to store nodes on the same level
        Queue<TreeNode> levelQueue = new LinkedList<>();
        // // a list to store nodes' value on the same level
        // List<Integer> levelElem = new ArrayList<>();
        levelQueue.add(root);
        while (!levelQueue.isEmpty()) {
            int levelSize = levelQueue.size();
            /*
             * // I really wonder why this is not working
             * // adding here lead to [[15, 7], [15, 7], [15, 7]]
             * if (!levelElem.isEmpty())
             *     levelElem.clear();
             */
            // a list to store nodes' value on the same level
            List<Integer> levelElem = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode temp = levelQueue.poll();
                levelElem.add(temp.val);
                if (temp.left != null)
                    levelQueue.add(temp.left);
                if (temp.right != null)
                    levelQueue.add(temp.right);
            }
            res.add(levelElem);
            // adding to here lead to [[], [], []]
            // if (!levelElem.isEmpty())
            //     levelElem.clear();
        }
        return res;
    }
}
// @lc code=end
