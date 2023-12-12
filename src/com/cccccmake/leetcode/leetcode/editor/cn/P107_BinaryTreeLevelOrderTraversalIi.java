package com.cccccmake.leetcode.leetcode.editor.cn;

//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 757 👎 0

import java.util.*;

/**
 * 二叉树的层序遍历 II
 *
 * @author cccccmake
 */
public class P107_BinaryTreeLevelOrderTraversalIi {
    public static void main(String[] args) {
        Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)

    // Definition for a binary tree node.
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Deque<TreeNode> layer = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            layer.offerLast(root);
            while (layer.size() != 0) {
                // the size of the queue is used to control the following for-loop
                int size = layer.size();
                List<Integer> layerContent = new ArrayList<>();
                for(int i = 0; i < size; i++) {
                    TreeNode node = layer.peekFirst();
                    layerContent.add(layer.pollFirst().val);
                    if(node.left != null)
                        layer.offerLast(node.left);
                    if(node.right != null)
                        layer.offerLast(node.right);
                }
                res.add(layerContent);
            }
            List<List<Integer>> reversedRes = new ArrayList<>();
            for(int i = res.size() - 1; i >= 0; i--){
                reversedRes.add(res.get(i));
            }
            return reversedRes;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}