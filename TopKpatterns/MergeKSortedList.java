package TopKpatterns;

import java.util.PriorityQueue;

class node {
    node next;
    int data;

    node(int data) {
        this.data = data;
    }
}

public class MergeKSortedList {
    public static node merge(node[] arr) {
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> (a.data - b.data));

        for (node values : arr) {
            pq.offer(values);
        }
        node head = new node(0);
        node dummy = head;

        while (pq.isEmpty() == false) {
            node temp = pq.poll();
            dummy.next = temp;
            dummy = dummy.next;
            node next = temp.next;
            if (next != null)
                pq.offer(next);
        }
        return head.next;
    }
}
