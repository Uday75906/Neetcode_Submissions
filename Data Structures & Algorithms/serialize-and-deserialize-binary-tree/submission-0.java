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

public class Codec {
     
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String dat) {
        String[] data = dat.split(",");
        Queue<String> q = new LinkedList<>();
        for(String s: data){
            q.offer(s);
        }
        return buildTree(q);
    }
    public void buildString(TreeNode root, StringBuilder s){
        if(root==null){
            s.append("#,");
            return;
        }
        s.append(root.val).append(",");
        buildString(root.left,s);
        buildString(root.right,s);
    }
    public TreeNode buildTree(Queue<String> q){
        String item = q.poll();
        if(item.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(item));
        node.left = buildTree(q);
        node.right = buildTree(q);
        
        return node;
    }
}
