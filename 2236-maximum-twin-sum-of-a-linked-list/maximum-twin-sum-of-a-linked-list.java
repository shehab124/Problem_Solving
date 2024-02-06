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

    public static ListNode Reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;

        while (next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        return curr;
    }


    public int pairSum(ListNode head) {
        int max = 0;

        if (head == null)
            return 0;

        int length = length(head) / 2;

        int i = 0;
        ListNode temp = head;
        while (i < length) {
            temp = temp.next;
            i++;
        }

        temp = Reverse(temp);

        while (head != null && temp != null) {
            int sum = head.val + temp.val;
            if (sum > max)
                max = sum;
            head = head.next;
            temp = temp.next;
        }

        return max;
    }
}