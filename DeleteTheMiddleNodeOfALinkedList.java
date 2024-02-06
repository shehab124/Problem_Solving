public class DeleteTheMiddleNodeOfALinkedList {

    public static int length(ListNode head) {
        int count = 0;

        while (head != null) {
            head = head.next;
            count++;
        }

        return count;
    }

    public static ListNode deleteMiddle(ListNode head) {

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

    public static void main(String[] args) {
        ListNode head = ListNode.Init(1, 2, 3, 4, 5, 6);

        ListNode head1 = deleteMiddle(head);
        head1.Print(head1);
    }
}
