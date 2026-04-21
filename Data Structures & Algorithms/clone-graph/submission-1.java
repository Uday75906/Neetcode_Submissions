/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
       Map<Integer, Node> map = new HashMap<>();
       map.put(node.val, new Node(node.val));
       Queue<Node> q = new LinkedList<>();
       q.add(node);
       while(!q.isEmpty()){
        Node original = q.poll();
        for(Node neighbor: original.neighbors){
            if(!map.containsKey(neighbor.val)){
                map.put(neighbor.val, new Node(neighbor.val));
                 q.offer(neighbor);
            }
            map.get(original.val).neighbors.add(map.get(neighbor.val));

           
        }
       }

       return map.get(node.val);
    }
}