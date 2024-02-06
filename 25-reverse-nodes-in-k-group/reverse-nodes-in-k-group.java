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

    public static int length(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int length = length(head);

        if (length < k) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;

        int count = 0;

        // Reverse the first k nodes
        while (count < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            count++;
        }

        // Recursively reverse the next k nodes
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k);
        }

        // 'prev' will now be the new head of the reversed group
        return prev;

    }
}