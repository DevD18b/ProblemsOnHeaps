package Implementation.ConversionOfHeaps;

import Implementation.minHeapify;

public class maxToMinHeap {
    // write your max heapify function first.
    // start from bottom most and right most internal node
    public static void maxHeapify(int[] arr, int n, int index) {
        // index is index of root itself.
        int root = index;
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        if (lc < n && arr[lc] > arr[root]) {
            root = lc;
        }
        if (rc > n && arr[rc] > arr[root]) {
            root = rc;
        }
        if (root != index) {
            int temp = arr[index];
            arr[index] = arr[root];
            arr[root] = temp;
            maxHeapify(arr, n, root);
        }
    }

    public static void conversion(int[] arr, int n) {
        int len = (n - 2) / 2;
        for (int i = len; i >= 0; i--) {
            maxHeapify(arr, len, i);
        }
    }
}
