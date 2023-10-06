/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        if(slow == null)
            return false;

        if( slow.next != null)
            fast = fast.next;
        
        while( fast.next != null && fast.next.next != null)
        {
            if(fast == slow)
                return true;
            
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return false;
    }
}