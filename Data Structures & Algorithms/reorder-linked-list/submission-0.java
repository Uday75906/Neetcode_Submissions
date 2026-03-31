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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head==null || head.next == null){
            return;
        }
        else{
            while(fast.next !=null && fast.next.next !=null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        ListNode prev = null;
        ListNode temp = slow.next;
        while(temp != null){
            ListNode t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        slow.next = null;
        ListNode a = head;
        ListNode b = prev;
        
        while(a != null && b != null){
            ListNode temp1 = b.next;
            ListNode temp2 = a.next;
            a.next = b;
            a = temp2;
            b.next = a;
            b = temp1;
        }
        if(a!=null){
            a.next = null;
        }
    }
}
