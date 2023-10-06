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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode head = new ListNode();
        if(list1.val <= list2.val)
        {
            head.val = list1.val;
            list1 = list1.next;
        }
        else
        {
            head.val = list2.val;
            list2 = list2.next;
        }
        
        ListNode pointer = head;
        ListNode newNode;
        while(list1 != null && list2 != null)
        {
            newNode = new ListNode();
            if(list1.val <= list2.val)
            {
                newNode.val = list1.val; // set value
                pointer.next = newNode; //connect new node
                pointer = pointer.next; //move pointer
                list1 = list1.next; // move in list1
            }
            else
            {
                newNode.val = list2.val; // set value
                pointer.next = newNode; //connect new node
                pointer = pointer.next; //move pointer
                list2 = list2.next; // move in list1
            }
        }

        if(list1 != null)
            pointer.next = list1;
        if(list2 != null)
            pointer.next = list2;

        return head;
    }
}