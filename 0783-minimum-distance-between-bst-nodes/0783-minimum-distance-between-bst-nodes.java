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

    int min = Integer.MAX_VALUE;
    int temp = Integer.MIN_VALUE + 1000000;

    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null){
            minDiffInBST(root.left);
        }

        min = Math.min(min, root.val - temp);
        temp = root.val;
        System.out.println(min);
        System.out.println(temp);
        if(root.right != null){
            minDiffInBST(root.right);
        }
        return min;
    }
}