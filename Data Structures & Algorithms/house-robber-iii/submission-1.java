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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root==null) return 0;

        if(map.containsKey(root)) return map.get(root);

        int skipcurrent = rob(root.left)+rob(root.right);

        int robcurrent = root.val;
        if(root.left!=null){
            robcurrent += rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            robcurrent += rob(root.right.left)+rob(root.right.right);
        }

        int result = Math.max(robcurrent,skipcurrent);
        map.put(root,result);
        return result;
    }
}