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
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        int length = length(head);

        int location = length / 2;

        int count = 0;

        ListNode current = head;
        ListNode prev = null;
        while (count < location) {
            prev = current;
            current = current.next;
            count++;
        }

        prev.next = current.next;

        return head;
    }
}