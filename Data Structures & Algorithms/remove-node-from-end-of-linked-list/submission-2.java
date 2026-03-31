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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head==null) return head;
       if(head.next==null) return head.next;
       
       ListNode prev = null;
       ListNode a = head;
       while(a != null){
        ListNode temp = a.next;
        a.next = prev;
        prev = a;
        a = temp;
       }
       
       ListNode temp = prev;
       ListNode prev1 = null;
       for(int i=1; i<=n; i++){
        if(n==1){
           prev = prev.next;
        }
        else if(i==n){
          prev1.next = temp.next;
        }
        prev1 = temp;
        temp = temp.next;
       }

       ListNode prev2 = null;
       while(prev != null){
        ListNode temp1 = prev.next;
        prev.next = prev2;
        prev2 = prev;
        prev = temp1;
       }

    return prev2;
    }
}
