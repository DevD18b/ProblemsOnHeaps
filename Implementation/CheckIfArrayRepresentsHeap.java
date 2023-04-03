package Implementation;

public class CheckIfArrayRepresentsHeap {
    public static boolean check(int[] arr, int n) {

        // check if it is a leaf
        if (arr.length <= 1)
            return true;
        int len = (n - 2) / 2;
        for (int i = 0; i <= len; i++) {
            if (arr[i] > arr[2 * i + 1] || (2 * i + 2) != arr.length && arr[i] > arr[2 * i + 2]) {
                return false;
            }
        }
        return true;

    }

    // lets see how recursive code works here.
    public static boolean recursive(int[] arr, int index) {
        //
        if (arr.length <= 2 * index + 2)
            return true;

        boolean left = (arr[index] <= arr[2 * index + 1] && recursive(arr, 2 * index + 1));
        boolean right = (2 * index + 2 <= arr.length
                || arr[index] < arr[2 * index + 2] && recursive(arr, 2 * index + 2));
        return left && right;
    }

}
