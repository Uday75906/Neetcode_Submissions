/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {\ this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int k) {
        if(root==null) return null;

        root.left = removeLeafNodes(root.left,k);
        root.right = removeLeafNodes(root.right,k);

        if(root.val==k && root.left==null && root.right==null){
            return null;
        }

        return root;
    }
}