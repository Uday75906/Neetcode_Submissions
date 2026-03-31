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
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
      ListNode slow = head;
      ListNode fast = head.next;
      while(fast != null){
        if(fast.next == null || fast==null){
        return false;
        }
        else{
            fast = fast.next.next;
        }
        slow = slow.next;
        if(fast==slow) return true;
      }  
    return false;
       }
}
