package Implementation;

public class extractMin {

}

class minHeaps {
    int size;
    int cap;
    int[] arr;

    minHeaps(int cap) {
        this.cap = cap;
        this.arr = new int[cap];
        this.size = 0;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    void Heapify(int index) {
        int smallest = index;
        int lc = left(index);
        int rc = right(index);
        if (lc < size && arr[lc] < arr[smallest]) {
            smallest = lc;
        }
        if (rc < size && arr[rc] < arr[smallest]) {
            smallest = rc;
        }
        if (smallest != index) {
            int temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = temp;
            Heapify(smallest);
        }
    }

    int extractMin() {
        if (size == 0) {
            return Integer.MAX_VALUE;
        }
        if (size == 1) {
            size--;
            return arr[0];
        }
        int temp = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = temp;
        size--;
        Heapify(0);
        // in the end remove the removed item 20.
        return arr[size];

    }
}
