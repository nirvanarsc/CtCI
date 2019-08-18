public final class C10Problem3 {

    public static void main(String[] args) {
        final int[] ints = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        for (int i : ints) {
            System.out.println(binarySearchRotatedArray(ints, i));
        }
    }

    private static int binarySearchRotatedArray(int[] a, int x) {
        int i = 1;
        while (a[i - 1] < a[i]) {
            i++;
        }
        int low = 0;
        int high = a.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            final int lookup = (mid + i) % a.length;
            if (a[lookup] < x) {
                low = mid + 1;
            } else if (a[lookup] > x) {
                high = mid - 1;
            } else {
                return lookup;
            }
        }
        return -1;
    }

    private C10Problem3() {
    }
}
