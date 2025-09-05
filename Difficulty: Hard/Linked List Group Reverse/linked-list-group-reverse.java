/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevGroupEnd = dummy;
        Node curr = head;

        while (curr != null) {
            Node groupStart = curr;
            Node groupEnd = curr;
            int count = 1;
            while (count < k && groupEnd.next != null) {
                groupEnd = groupEnd.next;
                count++;
            }

            Node nextGroupStart = groupEnd.next;
            reverse(groupStart, groupEnd);
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    private void reverse(Node start, Node end) {
        Node prev = null;
        Node curr = start;
        Node stop = end.next;

        while (curr != stop) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
