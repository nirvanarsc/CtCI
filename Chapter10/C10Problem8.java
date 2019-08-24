import java.util.stream.IntStream;

public final class C10Problem8 {

    static final int RADIX = 8;
    static final byte[] BITFIELD = new byte[4001];

    public static void main(String[] args) {
        final IntStream a = IntStream.rangeClosed(1, 100);
        final IntStream b = IntStream.rangeClosed(20, 30);
        printDuplicates(IntStream.concat(a, b).toArray());
    }

    static void printDuplicates(int[] array) {
        for (int n : array) {
            if ((BITFIELD[n / RADIX] & (1 << (n % RADIX))) != 0) {
                System.out.println(n);
            } else {
                BITFIELD[n / RADIX] |= 1 << (n % RADIX);
            }
        }
    }

    private C10Problem8() {
    }
}
