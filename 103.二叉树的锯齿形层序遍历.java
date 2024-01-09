/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> levelQueue = new LinkedList<>();
        if (root != null)
            levelQueue.add(root);
        boolean reverseBit = false;
        while (!levelQueue.isEmpty()) {
            List<Integer> levelElem = new ArrayList<>();
            int queueSize = levelQueue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode element = levelQueue.poll();
                levelElem.add(element.val);
                if (element.left != null)
                    levelQueue.add(element.left);
                if (element.right != null)
                    levelQueue.add(element.right);
            }
            if (reverseBit) {
                Collections.reverse(levelElem);
            }
            res.add(levelElem);
            reverseBit = !reverseBit;
        }
        return res;
    }
}
// @lc code=end
