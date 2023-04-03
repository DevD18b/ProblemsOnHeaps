package TopKpatterns;

import java.util.PriorityQueue;

public class kthLargestElementInStream {
    PriorityQueue<Integer> pq;
    int size;

    void kthLargestElmentInStream(int kth, int[] arr) {
        pq = new PriorityQueue<>();
        size = kth;
        for (int i : arr)
            pq.offer(i);

        if (pq.size() > kth)
            pq.poll();
    }

    int add(int val) {
        pq.offer(val);
        if (pq.size() > size) {
            pq.poll();
        }
        return pq.peek();

    }
}
