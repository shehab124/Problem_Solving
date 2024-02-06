class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;

        int iterations = right - left + 1;

        ListNode prev = null;
        ListNode currentNode = head;

        int i = 1;
        while (i < left) {
            prev = currentNode;
            currentNode = currentNode.next;
            i++;
        }

        ListNode connection = prev;
        ListNode tail = currentNode;

        i = 0;
        while (i < iterations) {
            ListNode next_node = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = next_node;
            i++;
        }

        if (connection != null)
            connection.next = prev;
        else {
            head = prev;
        }

        tail.next = currentNode;

        return head;
    }
}

/**
 * ReverseLinkedList2
 */
public class ReverseLinkedList2 {

    public static void main(String[] args) {

    }
}