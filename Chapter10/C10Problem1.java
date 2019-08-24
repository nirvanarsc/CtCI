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
        int aIndex = 0;
        while (a[aIndex + 1] != 0) {
            aIndex++;
        }
        for (int i = a.length - 1, bIndex = b.length - 1; i >= 0; i--) {
            if (bIndex < 0 || a[aIndex] > b[bIndex]) {
                a[i] = a[aIndex];
                aIndex--;
            } else {
                a[i] = b[bIndex];
                bIndex--;
            }
        }
    }
}
