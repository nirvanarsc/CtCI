import org.jetbrains.annotations.Contract;

import static java.lang.Integer.toBinaryString;

final class C5Problem1 {

    public static void main(String[] args) {
        final int n = (int) Math.pow(2, 10);
        final int m = 19;

        System.out.println(toBinaryString(insertAt(n, m, 2, 6)));
        System.out.println(toBinaryString(insertAt(n, m, 4, 8)));

        final int n1 = ~0;

        System.out.println(toBinaryString(updateBits(n1, m, 2, 6)));
        System.out.println(toBinaryString(updateBits(n1, m, 4, 8)));
    }

    private static int insertAt(int n, int m, int i, int j) {
        int length = toBinaryString(m).length();
        while (length > 0) {
            if (getBit(m, --length)) {
                n = setBit(n, j);
            }
            j--;
        }
        return n;
    }

    private static int updateBits(int n, int m, int i, int j) {
        final int allOnes = ~0;
        final int left = allOnes << (j + 1);
        final int right = (1 << i) - 1;
        final int mask = left | right;
        final int n_cleared = n & mask;
        final int m_shifted = m << i;
        return n_cleared | m_shifted;
    }

    @Contract(pure = true)
    private static boolean getBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    @Contract(pure = true)
    private static int setBit(int num, int i) {
        return num | (1 << i);
    }
}
