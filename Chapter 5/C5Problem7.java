public final class C5Problem7 {

    private C5Problem7() {
    }

    public static void main(String[] args) {
        final int integer = Integer.valueOf("10101010", 2);
        System.out.println(toFullBinaryString(integer));
        System.out.println(toFullBinaryString(pairwiseSwap(integer)));
        System.out.println(toFullBinaryString(29));
        System.out.println(toFullBinaryString(pairwiseSwap(29)));
        System.out.println();

        System.out.println(toFullBinaryString(integer));
        System.out.println(toFullBinaryString(swapOddEvenBits(integer)));
        System.out.println(toFullBinaryString(29));
        System.out.println(toFullBinaryString(swapOddEvenBits(29)));
        System.out.println();

        System.out.println(pairwiseSwap(integer) == swapOddEvenBits(integer));
        System.out.println(pairwiseSwap(29) == swapOddEvenBits(29));
    }

    static int swapOddEvenBits(int x) {
        // 0xa = 1010 (10)
        // 0xaaaaaaaa = 10101010101010101010101010101010
        // 0x5 = 0101 (5)
        // 0x55555555 = 01010101010101010101010101010101
        final int oddShifted = (x & 0xaaaaaaaa) >>> 1;
        final int evenShifted = (x & 0x55555555) << 1;
        return oddShifted | evenShifted;
    }

    static int pairwiseSwap(int num) {
        int res = 0;
        final int size = Integer.SIZE - 2;
        int curr;
        for (int i = size; i >= 0; i -= 2) {
            curr = getPairAt(num, i);
            if (curr == 0 || curr == 3) {
                res |= curr << i;
            }
            if (curr == 2) {
                res |= 1 << i;
            }
            if (curr == 1) {
                res |= 2 << i;
            }
        }

        return res;
    }

    static int getPairAt(int num, int i) {
        final int mask = ((1 << 2) - 1) << i;
        return (num & mask) >> i;
    }

    static String toFullBinaryString(int num) {
        return String.format("%32s", Integer.toString(num, 2))
                .replace(' ', '0');
    }
}
