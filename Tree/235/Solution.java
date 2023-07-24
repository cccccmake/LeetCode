/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
//         if(root == null || root == p || root == q) return root;
//         TreeNode node1;
//         TreeNode node2;

//         if(p.val > root.val) node1 = lowestCommonAncestor(root.right, p, q);
//         else node1 = lowestCommonAncestor(root.left, p, q);
        
//         if(q.val > root.val) node1 = lowestCommonAncestor(root.right, p, q);
//         else node1 = lowestCommonAncestor(root.left, p, q);
        
//         if(node1 != null && node2 != null) return root;
//         else if(node1 != null && node2 == null) return node1;
//         else if(node1 == null && node2 != null) return node2;
//         else return null;
//     }
// }

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root.val < p.val && root.val < q.val){
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(right != null) return right;
        }
        else if(root.val > p.val && root.val > q.val){
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if(left != null) return left;
        }
        else
            return root;
    }
}