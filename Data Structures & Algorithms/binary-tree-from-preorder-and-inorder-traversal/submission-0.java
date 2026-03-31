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
    int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return divide(preorder,inorder,0,preorder.length-1);
    }
    public TreeNode divide(int[] pre, int[] in,int left, int right){
        int index = 0;
         if(left>right){
            return null;
        }
        for(int i=left; i<=right; i++){
            if(pre[p]==in[i]){
                index = i;
                break;
            }
        }
       
        TreeNode node = new TreeNode(pre[p]);
        p++;
        node.left = divide(pre, in, left, index-1);
        node.right = divide(pre,in,index+1,right);

        return node;
    }
}
