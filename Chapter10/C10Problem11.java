import java.util.Arrays;

public final class C10Problem11 {

    public static void main(String[] args) {
        final int[] ints = {5, 3, 1, 2, 3};
        System.out.println(Arrays.toString(ints));
        sortValleyPeak(ints);
        System.out.println(Arrays.toString(ints));
    }

    static void sortValleyPeak(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            final int biggestIndex = maxIndex(array, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(array, i, biggestIndex);
            }
        }
    }

    static int maxIndex(int[] array, int a, int b, int c) {
        final int len = array.length;
        final int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        final int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        final int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        final int max = Math.max(aValue, Math.max(bValue, cValue));

        if (aValue == max) {
            return a;
        }
        if (bValue == max) {
            return b;
        }
        return c;
    }

    static void swap(int[] array, int left, int right) {
        final int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    private C10Problem11() {
    }
}
