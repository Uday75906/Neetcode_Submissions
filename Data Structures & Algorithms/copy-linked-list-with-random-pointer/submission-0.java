/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if(head==null) return null;
       Node curr = head;
       while(curr != null){
        Node clone = new Node(curr.val);
        clone.next = curr.next;
        curr.next = clone;
        curr = curr.next.next;
       }

       curr = head;
       while(curr != null){
        if(curr.random != null){
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
       }

       Node newnode = head.next;
       Node currold = head;
       Node currnew = head.next;
       while(currold != null){
        currold.next = currold.next.next;
         if(currold.next != null){
            currnew.next = currnew.next.next;
         }
         currold = currold.next;
         currnew = currnew.next; 
        } 
    return newnode;
    }
}
