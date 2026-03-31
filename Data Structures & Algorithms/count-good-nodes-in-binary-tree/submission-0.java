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
    PriorityQueue<Integer> r = new PriorityQueue<>(Collections.reverseOrder());
    int count = 0;
    public int goodNodes(TreeNode root) {
        good(root);
        return count;
    }
    public void good(TreeNode root){
      if(root==null) return;
      if(r.isEmpty() || r.peek()<=root.val){
        count++;
      }
      r.offer(root.val);
      good(root.left);
      good(root.right);
      
      r.remove(root.val);
    }
}
