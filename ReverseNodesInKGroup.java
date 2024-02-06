/**
 * ReverseNodes in K-Group
 */
public class ReverseNodesInKGroup {

    public static int length(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

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

    public static void main(String[] args) {

        ListNode head = ListNode.Init(1, 2, 3, 4, 5, 6, 7);
        ListNode head1 = reverseKGroup(head, 3);
        head1.Print(head1);
    }
}