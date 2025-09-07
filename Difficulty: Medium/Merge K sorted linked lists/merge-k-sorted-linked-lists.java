/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

import java.util.*;

class Solution {
    Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.data - b.data;
            }
        });

        for (Node head : arr) {
            if (head != null) {
                pq.add(head);
            }
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            tail.next = curr;
            tail = tail.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }

        return dummy.next;
    }
}

