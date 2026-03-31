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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;

      ListNode prevgrouptail = dummy;
      while(true){
        ListNode kthNode = getKthNode(prevgrouptail, k);
        if(kthNode==null) break;

        ListNode nextgrouphead = kthNode.next;

        ListNode currgrouphead = prevgrouptail.next;
        reverse(currgrouphead, k);

        currgrouphead.next = nextgrouphead;
        prevgrouptail.next = kthNode;

        prevgrouptail = currgrouphead;
      }

      return dummy.next;
    }
    public ListNode getKthNode(ListNode start, int k){
        while(start!=null && k>0){
            start = start.next;
            k--;
        }
        return start;
    }
    public void reverse(ListNode node, int k){
        ListNode prev = null;
        ListNode curr = node;
        while(k>0){
            ListNode temp = curr.next;
            curr.next =  prev;
            prev = curr;
            curr = temp;
            k--;
        }
    }
}
