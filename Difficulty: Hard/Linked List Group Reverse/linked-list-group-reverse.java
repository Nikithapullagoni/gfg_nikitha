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

        Node curr = head, prev = null, next = null;
        int count = 0;

        // Reverse up to k nodes (or until list ends)
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // head is now the last node in the reversed group
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // prev is the new head of this group
        return prev;
    }
}
