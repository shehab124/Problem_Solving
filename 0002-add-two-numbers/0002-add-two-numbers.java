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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        ListNode newNode;
        int carry = 0;
        int sum = 0;

        if(l1 != null)
        {
            sum += l1.val;
            l1 = l1.next;
        }
        if(l2 != null)
        {
            sum += l2.val;
            l2 = l2.next;
        }
        if(sum > 9)
        {
            temp.val = sum % 10;
            carry = 1;
        }
        else
            temp.val = sum;
        
        while(l1 != null || l2 != null)
        {
            sum = 0;
            newNode = new ListNode();
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }
            if(carry != 0)
                sum += carry;
            
            if(sum > 9)
            {
                newNode.val = sum % 10;
                carry = 1;
            }
            else {
                newNode.val = sum;
                carry = 0;
            }
            temp.next = newNode;
            temp = temp.next;
        }
        if(carry == 1) {
            newNode = new ListNode(1);
            temp.next = newNode;
        }
        
        return head;
    }
}