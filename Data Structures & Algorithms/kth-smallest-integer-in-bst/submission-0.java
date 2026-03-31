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
    int index = 1;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
       kthnumber(root,k);
       return res;
    }
    public void kthnumber(TreeNode root, int k){
     if(root==null) return;
     kthnumber(root.left,k);
      if(index==k){
        res = root.val;
        index++;
        return;
      }
      index++; 
      kthnumber(root.right,k);
       return ;
      
    }
}
