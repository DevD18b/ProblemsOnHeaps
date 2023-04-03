package TopKpatterns;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianInStream {
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    MedianInStream() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
    }

    void addNumber(int data) {
        if (maxheap.isEmpty() || maxheap.peek() > data) {
            maxheap.offer(data);
        } else {
            minheap.offer(data);
        }
        if (minheap.size() > maxheap.size() + 1) {
            maxheap.offer(minheap.remove());
        } else if (maxheap.size() > minheap.size() + 1) {
            minheap.offer(maxheap.remove());
        }
    }

    double findMedian() {
        if (minheap.size() == maxheap.size()) {
            return (double) (minheap.peek() + maxheap.peek()) / 2;
        }
        else if(minheap.size()>maxheap.size()){
        return minheap.peek()
        }

        else{
            return maxheap.peek();
        }
    }

}
