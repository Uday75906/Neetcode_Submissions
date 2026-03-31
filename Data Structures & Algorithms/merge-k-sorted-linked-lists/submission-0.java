/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val-b.val);
       for(int i=0; i<lists.length; i++){
        ListNode node = lists[i];
        while(node!=null){
            pq.offer(node);
            node = node.next;
        }
       }
       ListNode dummy = new ListNode(0);
       ListNode curr = dummy;
       
       while(!pq.isEmpty()){
        ListNode smallest = pq.poll();
        curr.next = smallest;
        curr = curr.next;
       }
       return dummy.next;
    }
}
