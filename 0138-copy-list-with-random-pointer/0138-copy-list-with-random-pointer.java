/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node head2 = new Node(head.val);
        Node temp = head.next, temp2 = head2;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, head2);
        map.put(null, null);
        // copy
        while (temp != null) {
            Node n = new Node(temp.val);
            temp2.next = n;
            temp2 = n;
            map.put(temp, temp2);
            temp = temp.next;
        }

        temp = head;
        temp2 = head2;
        while (temp != null) {
            temp2.random = map.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}