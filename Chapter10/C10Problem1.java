import java.util.Arrays;

public final class C10Problem1 {

    public static void main(String[] args) {
        final int[] a = new int[20];
        for (int i = 1; i <= 15; i++) {
            a[i - 1] = i;
        }

        final int[] b = {5, 10, 15, 25, 35};

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        mergeArrays(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    private static void mergeArrays(int[] a, int[] b) {
        for (int i = 0, j = 0; i < a.length; i++) {
            if (a[i] > b[j]) insert(a, b[j++], i);
            if (a[i] == 0) a[i] = b[j++];
        }
    }

    private static void insert(int[] a, int val, int index) {
        if (val == 0) return;

        final int temp = a[index];
        a[index] = val;
        insert(a, temp, index + 1);
    }
}
