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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode curr1 = list1;
      ListNode curr2 = list2;
      ListNode head = null;
      ListNode prev1 = null;
      ListNode prev2 = null;
      if(list1==null && list2==null){
        return null;
      }
      else if(list1==null){
        return list2;
      }
      else if(list2==null){
        return list1;
      }
      if(curr1.val <= curr2.val){
        head = curr1;
        prev1 = curr1;
        prev2 = curr1;
        curr1 = curr1.next;
      }
      else{
        head = curr2;
        prev1 = curr2;
        prev2 = curr2;
        curr2 = curr2.next;
      }
      while(curr1 != null && curr2 != null){
        ListNode temp1 = curr1.next;
        ListNode temp2 = curr2.next;
        if(curr1.val <= curr2.val){
             prev2.next = curr1;
             prev1 = curr1;
             prev2 = curr1;
             curr1 = temp1;
        }
        else{
            prev1.next = curr2;
            prev2 = curr2;
            prev1 = curr2;
            curr2 = temp2;
        }
      }
      if(curr1==null){
        while(curr2 != null){
            prev1.next = curr2;
            prev1 = curr2;
            curr2 = curr2.next;
        }
      }
      else{
        while(curr1 != null){
            prev2.next = curr1;
            prev2 = curr1;
            curr1 = curr1.next;
        }
      }  
    return head;
    }
}