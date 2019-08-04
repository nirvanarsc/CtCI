public final class C8Problem3 {

    private C8Problem3() {
    }

    public static void main(String[] args) {
        final int[] distinct = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        final int[] duplicate = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};

        System.out.println(distinctMagic(distinct));
        System.out.println(magic(duplicate));
    }

    // For sorted distinct array
    static int distinctMagic(int[] arr) {
        return distinctMagic(arr, 0, arr.length - 1);
    }

    static int distinctMagic(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int mid = (start + end) / 2;

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] > mid) {
            return distinctMagic(arr, start, mid - 1);
        } else {
            return distinctMagic(arr, mid + 1, end);
        }
    }

    // For sorted array with duplicates
    static int magic(int[] arr) {
        return magic(arr, 0, arr.length - 1);
    }

    static int magic(int[] arr, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int mid = (start + end) / 2;
        final int midValue = arr[mid];

        if (midValue == mid) {
            return mid;
        }

        // Search left
        final int leftIndex = Math.min(mid - 1, midValue);
        final int left = magic(arr, start, leftIndex);
        if (left >= 0) {
            return left;
        }
        // Search right
        final int rightIndex = Math.max(mid + 1, midValue);
        return magic(arr, rightIndex, end);
    }
}
