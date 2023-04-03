package Implementation.ConversionOfHeaps;

public class minToMaxInLinearTime {

    // a zero indexed array representing a heap
    // has range of leafs starting from floor(n/2) to n-1;
    // where as 0 to n-1 are all the internal nodes.

    public static void minHeapify(int index, int[] arr, int n) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int root = index;

        if (left < n && arr[root] > arr[left]) {
            root = left;
        }
        if (right < n && arr[root] > arr[right]) {
            root = right;
        }
        if (root != index) {
            int temp = arr[index];
            arr[index] = arr[root];
            arr[root] = temp;
            minHeapify(root, arr, n);
        }
    }

    public static void conversion(int[] arr, int n) {
        int len = (int) Math.floor(n / 2) - 1;
        for (int i = len; i >= 0; i--) {
            minHeapify(i, arr, n);
        }
    }
}
