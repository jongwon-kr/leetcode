/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode result = dfs(root);
        return result;
    }

    public TreeNode dfs(TreeNode node){
        if(node == null){
            return null;
        }

        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);

        node.right = left;
        node.left = right;

        return node;
    }
}