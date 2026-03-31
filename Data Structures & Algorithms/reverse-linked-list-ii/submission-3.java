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
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode tail = dummy;
      for(int i=0; i<left-1; i++){
        tail = tail.next;
      }
      ListNode start = tail.next;
      ListNode then = start.next;
      for(int i=0; i<right-left; i++){
        start.next = then.next;
        then.next = tail.next;
        tail.next = then;
        then = start.next;
      }
      return dummy.next;

    }
}