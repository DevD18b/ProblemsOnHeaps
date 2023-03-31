package Implementation;

public class minHeapify {

}

class ImplemenatingHeaps {
    int cap;
    int[] arr;
    int index;

    ImplemenatingHeaps(int cap) {
        this.cap = cap;
        this.arr = new int[cap];
        this.index = 0;
    }

    int left(int index) {
        return 2 * index + 1;
    }

    int right(int index) {
        return 2 * index + 2;
    }

    int parent(int index) {
        return (index - 1) / 2;
    }

    // probably i will be passing roots index to it.
    void Heapify(int index) {
        int smallest = index;
        int leftChild = left(index);
        int rightChild = right(index);
        if (leftChild < this.cap && arr[index] > arr[leftChild]) {
            smallest = leftChild;
        }

        if (rightChild < this.cap && arr[index] > arr[rightChild]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            swap(arr[index], arr[smallest]);
            Heapify(smallest);
        }
    }

    void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }

}
