package minNumberPattern;

import java.util.*;

public class MedianFromDataStream {

    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    MedianFromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    void addData(int data) {
        // compair on the backgrounds of data.
        if (maxHeap.isEmpty() || maxHeap.peek() > data) {
            maxHeap.offer(data);
        } else {
            minHeap.offer(data);
        }
        // compair on the backgrounds of size.

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
    }

    public double median() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.size() + maxHeap.size()) / 2;
        }
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

}
