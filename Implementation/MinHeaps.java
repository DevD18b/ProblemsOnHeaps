package Implementation;

public class MinHeaps {

}

class ImplementationMinHeap {
    int index;
    int capacity;
    int[] arr;

    ImplementationMinHeap(int cap) {

        this.capacity = cap;
        this.arr = new int[cap];
        this.index = 0;
    }

    int left(int i) {
        return 2 * index + 1;
    }

    int right(int i) {
        return 2 * index + 2;
    }

    int parent(int i) {
        return (int) ((i - 1) / 2);
    }

    public void insert(int x) {
        if (index == capacity)
            return;
        index++;
        arr[index - 1] = x;
        for (int i = index - 1; i != 0 && arr[parent(i)] > arr[i];) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

}