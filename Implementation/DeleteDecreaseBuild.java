package Implementation;

public class DeleteDecreaseBuild {
    int[] arr;
    int index;
    int size;

    DeleteDecreaseBuild(int cap) {
        this.size = cap;
        this.arr = new int[cap];
        this.index = 0;
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    void swap(int i, int j) {
        int temp = i;
        i = j;
        j = i;
    }

    void DecreaseKey(int i, int data) {
        arr[i] = data;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(arr[parent(i)], arr[i]);
            i = parent(i);
        }
    }

    int extractMin() {
        if (size == 1) {
            size--;
            return arr[0];
        }
        if (size <= 0) {
            return Integer.MAX_VALUE;
        }
        swap(arr[0], arr[size - 1]);
        size--;
        minHeapify(0);

        return arr[size];
    }

    void minHeapify(int index) {
        int lc = left(index);
        int rc = right(index);
        int root = index;
        if (lc < size && arr[lc] < root) {
            root = lc;
        } else if (rc < size && arr[rc] < root) {
            root = rc;
        }
        if (root != index) {
            int temp = arr[root];
            arr[root] = arr[index];
            arr[index] = temp;
            minHeapify(root);
        }

    }

    void deleteKey(int index) {

        DecreaseKey(index, (int) 1e9);
        extractMin();
    }

    void insert(int data) {
        if (index == this.size)
            return;
        this.index++;
        this.arr[this.index - 1] = data;
        for (int i = index - 1; i >= 0 && arr[parent(i)] > arr[i];) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }

}
