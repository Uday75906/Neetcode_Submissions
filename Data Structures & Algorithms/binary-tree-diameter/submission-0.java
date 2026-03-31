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
    int maxdiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        left(root);
        return maxdiameter;
    }
    public int left(TreeNode root){
        if(root==null) return 0;
        int lefth = left(root.left);
        int righth = left(root.right);

        maxdiameter = Math.max(maxdiameter, righth+lefth);
        return 1+Math.max(righth,lefth);
    }
}
